package com.example.flowerShop.services;

import com.example.flowerShop.models.CartEntity;
import com.example.flowerShop.models.ProductInfoEntity;
import com.example.flowerShop.models.UserInfoEntity;
import com.example.flowerShop.repositories.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public List<ProductInfoEntity> getCartProductsByUser(UserInfoEntity userInfoEntity) {

        List<CartEntity> cartEntities = cartRepository.findByUserInfoEntity(userInfoEntity);


        return cartEntities.stream()
                .map(CartEntity::getProductInfoEntity)
                .toList();
    }
}
