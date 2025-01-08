package com.example.flowerShop.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "image_info")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageInfoEntity {

    @Id
    @SequenceGenerator(name="image_infoSequence", sequenceName="image_info_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="image_infoSequence")
    @Column(name = "id")
    private Long id;
//    @Column(name = "name")
//    private String name;
    @Column(name = "original_file_name")
    private String originalFileName;
    @Column(name = "size")
    private Long size;
    @Column(name = "content_type")
    private String contentType;
    @Column(name = "is_preview_image")
    private boolean isPreviewImage;
    @Lob
    private byte[] image = new byte[100000];
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private ProductInfoEntity product;

    public byte[] getBytes() {
        return image;
    }

    public void setBytes(byte[] bytes) {
        this.image = bytes;
    }


//    public void setBytes(byte[] bytes) {
//    }
}
