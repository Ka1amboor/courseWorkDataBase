package com.example.flowerShop.repositories;

import com.example.flowerShop.models.ProductInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductInfoEntity, Long> {
    List<ProductInfoEntity> findByTitle(String title);
}
