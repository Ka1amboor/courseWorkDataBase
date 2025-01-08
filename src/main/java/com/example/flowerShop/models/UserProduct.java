package com.example.flowerShop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfoEntity user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductInfoEntity product;

    public void addProductToUser(UserInfoEntity user, ProductInfoEntity product) {
        UserProduct userProduct = new UserProduct();
        userProduct.setUser(user);
        userProduct.setProduct(product);
        // Далее сохранение userProduct в базе данных через репозиторий
    }
}
