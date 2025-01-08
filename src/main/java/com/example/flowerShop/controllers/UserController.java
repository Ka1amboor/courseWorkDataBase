package com.example.flowerShop.controllers;

import com.example.flowerShop.models.UserInfoEntity;
import com.example.flowerShop.repositories.DAOFunction;
import com.example.flowerShop.repositories.Impl.DAOFunctionImpl;
import com.example.flowerShop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final DAOFunction daoFunction;

    @GetMapping("/login")
    public String login() {
        daoFunction.getCountAllFlowers(3l, "test");
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }


    @PostMapping("/registration")
    public String createUser(UserInfoEntity user, Model model) {;
        if(!userService.createUser(user)) {
            model.addAttribute("errorMessage", "Пользователь с email: " + user.getEmail() + "уже существует");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/hello")
    public String securityUrl() {
        return "hello";
    }

}
