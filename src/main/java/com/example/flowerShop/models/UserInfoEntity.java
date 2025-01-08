package com.example.flowerShop.models;

import com.example.flowerShop.models.enums.Role;
import com.example.flowerShop.repositories.RoleRepository;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Entity
@Table(name = "user_info")
@Data
public class UserInfoEntity implements UserDetails {



    @Id
    @SequenceGenerator(name="user_infoSequence", sequenceName="user_info_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_infoSequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "number_phone", unique = true)
    private String numberPhone;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "active")
    private boolean active;
    @Column(name = "password", length = 1000)
    private String password;
//    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_role",
//            joinColumns = @JoinColumn(name = "user_id"))
//    @Enumerated(EnumType.STRING)
//    private Set<Role> roles = new HashSet<>();
    @Setter
    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Role role;

    private LocalDateTime dateOfCreated;

    @ManyToMany()
    @JoinTable(name = "user_product", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<ProductInfoEntity> products;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userInfoEntity")
    private List<CartEntity> productsInCart;

    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }

    // security

    public boolean isAdmin() {
        return "ROLE_ADMIN".equals(role.getName());

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role.getName()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

}
