package com.example.flowerShop.repositories;

import com.example.flowerShop.models.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProductRepository extends JpaRepository<UserProduct, Long> {
}
