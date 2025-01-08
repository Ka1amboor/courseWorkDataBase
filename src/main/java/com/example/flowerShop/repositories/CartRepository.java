package com.example.flowerShop.repositories;

import com.example.flowerShop.models.CartEntity;
import com.example.flowerShop.models.ProductInfoEntity;
import com.example.flowerShop.models.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
    List<CartEntity> findByUserInfoEntity(UserInfoEntity userInfoEntity);
}
