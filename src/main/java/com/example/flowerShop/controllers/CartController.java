package com.example.flowerShop.controllers;

import com.example.flowerShop.models.ProductInfoEntity;
import com.example.flowerShop.models.UserInfoEntity;
import com.example.flowerShop.services.CartService;
import com.example.flowerShop.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
@Getter
@Setter
public class CartController {
    private final ProductService productService;
    private final CartService cartService;

    @PostMapping("/cart")
    public String cartContents(Principal principal, Model model) {

        UserInfoEntity user = productService.getUserByPrincipal(principal);

        List<ProductInfoEntity> cartProducts = cartService.getCartProductsByUser(user);

        model.addAttribute("products", cartProducts);
        model.addAttribute("user", user);

        return "in-cart";
    }
}
