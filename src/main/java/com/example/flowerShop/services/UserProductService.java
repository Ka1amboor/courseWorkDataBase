package com.example.flowerShop.services;

import com.example.flowerShop.models.ProductInfoEntity;
import com.example.flowerShop.models.UserInfoEntity;
import com.example.flowerShop.models.UserProduct;
import com.example.flowerShop.repositories.UserProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProductService {
    private final UserProductRepository userProductRepository;

    @Autowired
    public UserProductService(UserProductRepository userProductRepository) {
        this.userProductRepository = userProductRepository;
    }

    public void addProductToUser(UserInfoEntity user, ProductInfoEntity product) {
        UserProduct userProduct = new UserProduct();
        userProduct.setUser(user);
        userProduct.setProduct(product);
        userProductRepository.save(userProduct);
    }

}
