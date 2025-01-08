package com.example.flowerShop.repositories;

import com.example.flowerShop.models.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByName(String name);
}
