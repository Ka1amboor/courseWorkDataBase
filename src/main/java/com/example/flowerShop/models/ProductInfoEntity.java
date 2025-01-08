package com.example.flowerShop.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfoEntity {

    @Id
    @SequenceGenerator(name="product_infoSequence", sequenceName = "product_info_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_infoSequence")
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @Column(name = "price")
    private int price;
    @Column(name = "supplier")
    private String supplier;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private List<ImageInfoEntity> images = new ArrayList<>();
    private Long previewImageId;

    @ManyToMany(mappedBy = "products")
    private List<UserInfoEntity> users;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productInfoEntity")
    private List<CartEntity> cartEntities;



    private LocalDateTime dateOfCreated;

    //было закомментировано
    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }

    public void addImageToProduct(ImageInfoEntity image) {
        image.setProduct(this);
        images.add(image);
    }

//    public Product() {
//    }

//    public String getTitle() {
//        return this.title;
//    }
//
//    public String getDescription() {
//        return this.description;
//    }
//
//    public int getPrice() {
//        return this.price;
//    }
//
//    public String getSupplier() {
//        return this.supplier;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public void setSupplier(String supplier) {
//        this.supplier = supplier;
//    }
//
//    public boolean equals(final Object o) {
//        if (o == this) return true;
//        if (!(o instanceof Product)) return false;
//        final Product other = (Product) o;
//        if (!other.canEqual((Object) this)) return false;
//        final Object this$title = this.getTitle();
//        final Object other$title = other.getTitle();
//        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
//        final Object this$description = this.getDescription();
//        final Object other$description = other.getDescription();
//        if (this$description == null ? other$description != null : !this$description.equals(other$description))
//            return false;
//        if (this.getPrice() != other.getPrice()) return false;
//        final Object this$supplier = this.getSupplier();
//        final Object other$supplier = other.getSupplier();
//        if (this$supplier == null ? other$supplier != null : !this$supplier.equals(other$supplier)) return false;
//        return true;
//    }
//
//    protected boolean canEqual(final Object other) {
//        return other instanceof Product;
//    }
//
//    public int hashCode() {
//        final int PRIME = 59;
//        int result = 1;
//        final Object $title = this.getTitle();
//        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
//        final Object $description = this.getDescription();
//        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
//        result = result * PRIME + this.getPrice();
//        final Object $supplier = this.getSupplier();
//        result = result * PRIME + ($supplier == null ? 43 : $supplier.hashCode());
//        return result;
//    }
//
//    public String toString() {
//        return "Product(title=" + this.getTitle() + ", description=" + this.getDescription() + ", price=" + this.getPrice() + ", supplier=" + this.getSupplier() + ")";
//    }
}
