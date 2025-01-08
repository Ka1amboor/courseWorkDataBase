package com.example.flowerShop.models.enums;

import com.example.flowerShop.models.UserInfoEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

//public enum Role implements GrantedAuthority {
//    ROLE_USER, ROLE_ADMIN;
//
//    @Override
//    public String getAuthority() {
//        return name();
//    }
@Table(name="role")
@Entity
@Getter
@Setter
public class Role {
    @Id
    @SequenceGenerator(name="roleSequence", sequenceName="role_seq", allocationSize = 1, initialValue = 3)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="roleSequence")
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private List<UserInfoEntity> users;
}
