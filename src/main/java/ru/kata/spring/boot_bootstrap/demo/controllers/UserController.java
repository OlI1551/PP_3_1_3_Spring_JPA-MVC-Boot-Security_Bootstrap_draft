package ru.kata.spring.boot_bootstrap.demo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_bootstrap.demo.models.User;


@Controller
public class UserController {
    @GetMapping("/user")
    public String showUserPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User authenticatedUser = (User) authentication.getPrincipal();
        model.addAttribute("user", authenticatedUser);

        return "user_page";
    }
}
