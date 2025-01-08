package com.example.flowerShop.services;

import com.example.flowerShop.models.CartEntity;
import com.example.flowerShop.models.ImageInfoEntity;
import com.example.flowerShop.models.ProductInfoEntity;
import com.example.flowerShop.models.UserInfoEntity;
import com.example.flowerShop.repositories.CartRepository;
import com.example.flowerShop.repositories.ProductRepository;
import com.example.flowerShop.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
//    SecurityContextHolder.getContext

    @Transactional
    public List<ProductInfoEntity> listProducts(String title) {
        if(title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }
    @Transactional
    public void saveProduct(Principal principal, ProductInfoEntity product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        product.setUsers(null);
        // Проверка: есть ли хотя бы одна фотография
        if ((file1 == null || file1.isEmpty()) &&
                (file2 == null || file2.isEmpty()) &&
                (file3 == null || file3.isEmpty())) {
            throw new IllegalArgumentException("Необходимо добавить хотя бы одну фотографию!");
        }
        ImageInfoEntity image1;
        ImageInfoEntity image2;
        ImageInfoEntity image3;
        if(file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            product.addImageToProduct(image1);
        }
        if(file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            product.addImageToProduct(image2);
        }
        if(file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            product.addImageToProduct(image3);
        }
        log.info("saving new Product. Title: {}; Supplier: {}", product.getTitle(), product.getSupplier());
        ProductInfoEntity productFromDb = productRepository.save(product);
        productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
        productRepository.save(product);
    }

    public UserInfoEntity getUserByPrincipal(Principal principal) {
        if(principal == null) return new UserInfoEntity();
        return userRepository.findByEmail(principal.getName());
    }


    private ImageInfoEntity toImageEntity(MultipartFile file) throws IOException {
        ImageInfoEntity image = new ImageInfoEntity();
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public ProductInfoEntity getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void addToCart(Long id) {


        ProductInfoEntity productInfoEntity = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Отсутствует товар в каталоге"));
        UserInfoEntity userInfoEntity = requestUserName();
        cartRepository.save(prepareCartToDb(userInfoEntity, productInfoEntity));

//        return "";
    }

    private UserInfoEntity requestUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal= authentication.getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        userDetails.getUsername();
        return userRepository.findByEmail(userDetails.getUsername());

    }

    private CartEntity prepareCartToDb(UserInfoEntity userInfoEntity, ProductInfoEntity productInfoEntity) {
        return new CartEntity(userInfoEntity, productInfoEntity);
    }
}
