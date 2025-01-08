package com.example.flowerShop.repositories;

import com.example.flowerShop.models.ImageInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageInfoEntity, Long> {
}
