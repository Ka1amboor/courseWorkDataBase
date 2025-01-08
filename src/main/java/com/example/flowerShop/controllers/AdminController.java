package com.example.flowerShop.controllers;

import com.example.flowerShop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
public class AdminController {

    private final UserService userService;

    public static final String BACKUP_DIR = "/Users/a.lisnyak/Downloads/flowerShop-main/flowerShop";

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("users", userService.userInfoEntityList());
        return "admin";
    }

    @PostMapping("/admin/user/ban/{id}")
    public String userBan(@PathVariable("id") Long id) {
        userService.banUser(id);
        return "redirect:/admin";
    }

    @PostMapping("/create")
    public String createBackUp(Model model) {
        try {


            String containerName = "flower_shop_db";

            String backupCommand = "docker exec -i " + containerName + " pg_dump -U postgres -h localhost -p 5432 -F c -b -v -f /path/to/backup/backup_file.dump flower_db";

            Process process = Runtime.getRuntime().exec(backupCommand);


            process.waitFor();

            model.addAttribute("message", "Резервная копия успешно создана!");

        } catch (Exception e) {

            model.addAttribute("error", "Ошибка создания резервной копии: " + e.getMessage());

        }

        return "backup";

    }




}
