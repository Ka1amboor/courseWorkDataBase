package com.example.flowerShop.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cart")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartEntity {

    @Id
    @SequenceGenerator(name="cart_Sequence", sequenceName="cart_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cart_Sequence")
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserInfoEntity userInfoEntity;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private ProductInfoEntity productInfoEntity;

    public CartEntity(UserInfoEntity userInfoEntity, ProductInfoEntity productInfoEntity) {
        this.userInfoEntity = userInfoEntity;
        this.productInfoEntity = productInfoEntity;
    }
}
