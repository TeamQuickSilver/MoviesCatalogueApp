package com.movies.restapi.controllers;

import com.movies.restapi.entities.User;
import com.movies.restapi.services.users.UserService;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public boolean login(User user) {
        return userService.loadUserByUsername(user.getUsername()) != null;
    }


    @PostMapping("users/register")
    public void register(User user) {
        userService.register(user.getUsername(), user.getPassword());
    }
}
