package com.example.flowerShop.services;

import com.example.flowerShop.models.UserInfoEntity;
import com.example.flowerShop.models.enums.Role;
import com.example.flowerShop.repositories.RoleRepository;
import com.example.flowerShop.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public boolean createUser(UserInfoEntity user){
        String email = user.getEmail();
        if(userRepository.findByEmail(email) != null)
            return false;
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role roleUser = roleRepository.findRoleByName("ROLE_USER"); //ранее был хардкор просто все пользователями регались
        user.setRole(roleUser);
        log.info("Saving new User with email: {}", email);
        userRepository.save(user);
        return true;
        

    }

    public List<UserInfoEntity> userInfoEntityList() {
        return userRepository.findAll();
    }

    public void banUser(Long id) {
        UserInfoEntity user = userRepository.findById(id).orElse(null);
        if (user != null) {
            if (user.isActive()) {
                user.setActive(false);
                log.info("Ban user with id = {}; email: {}", user.getId(), user.getEmail());
            } else {
                user.setActive(true);
                log.info("Unban user with id = {}; email: {}", user.getId(), user.getEmail());
            }
        }
        userRepository.save(user);
    }
}
