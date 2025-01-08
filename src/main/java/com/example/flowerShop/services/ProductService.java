package com.example.flowerShop.services;

import com.example.flowerShop.models.ImageInfoEntity;
import com.example.flowerShop.models.ProductInfoEntity;
import com.example.flowerShop.models.UserInfoEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

public interface ProductService {

    public List<ProductInfoEntity> listProducts(String title);

    public void saveProduct(Principal principal, ProductInfoEntity product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException;

    public UserInfoEntity getUserByPrincipal(Principal principal);

    public void deleteProduct(Long id);

    public ProductInfoEntity getProductById(Long id);

    public void addToCart(Long id);
}
