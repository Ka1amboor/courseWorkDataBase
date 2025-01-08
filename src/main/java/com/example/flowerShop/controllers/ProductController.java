package com.example.flowerShop.controllers;


import com.example.flowerShop.models.ProductInfoEntity;
import com.example.flowerShop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String products(@RequestParam(name = "title", required = false) String title,Principal principal, Model model){
        model.addAttribute("products", productService.listProducts(title));
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        return "products";
    }

    @GetMapping("/product/{id}")
    public String ProductInfo(@PathVariable Long id, Model model){
//        model.addAttribute("product", productService.getProductById(id));
//        return "product-info";

        ProductInfoEntity product = productService.getProductById(id);
        productService.addToCart(id);
        model.addAttribute("product", product);
        model.addAttribute("images", product.getImages());
        return "product-info";
    }

    @PostMapping("product/add-to-cart/{id}")
    public String addToCart(@PathVariable Long id) {
        productService.addToCart(id);
        return "redirect:/";
    }

    @PostMapping("product/create")
    public String createProduct(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3, ProductInfoEntity product, Principal principal) throws IOException {
        productService.saveProduct(principal, product, file1, file2, file3);
        return "redirect:/";
    }
    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }


}
