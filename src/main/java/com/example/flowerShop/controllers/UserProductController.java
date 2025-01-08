//package com.example.flowerShop.controllers;
//
//import com.example.flowerShop.models.Product;
//import com.example.flowerShop.models.User;
//import com.example.flowerShop.repositories.UserRepository;
//import com.example.flowerShop.services.ProductService;
//import com.example.flowerShop.services.UserProductService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.nio.file.attribute.UserPrincipal;
//
//@RestController
//@RequiredArgsConstructor
//public class UserProductController {
//
//    private final UserProductService userProductService;
//    private final UserRepository userRepository;
//    private final ProductService productService; // добавляем ProductService для получения продукта
//
//    @Autowired
//    public UserProductController(UserProductService userProductService,
//                                 UserRepository userRepository,
//                                 ProductService productService) {
//        this.userProductService = userProductService;
//        this.userRepository = userRepository;
//        this.productService = productService;
//    }
//
//    @PostMapping("/addProduct")
//    public void addProductToUser(@RequestBody UserProductDto userProductDto,
//                                 @AuthenticationPrincipal UserPrincipal userPrincipal) {
//        // Получаем текущего пользователя из UserPrincipal
//        User user = userRepository.getUserBy; // получаем пользователя
//
//        // Теперь получаем продукт по ID
//        Product product = productService.findById(userProductDto.getProductId()); // ищем продукт по ID
//
//        if (product == null) {
//            throw new ResourceNotFoundException("Продукт не найден"); // обрабатываем случай, когда продукт не найден
//        }
//
//        // Добавляем продукт пользователю
//        userProductService.addProductToUser(user, product);
//    }
//
//
//
//
//
//}
