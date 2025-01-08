package com.example.flowerShop.repositories;

import com.example.flowerShop.models.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfoEntity, Long> {
    UserInfoEntity findByEmail(String email);
}
