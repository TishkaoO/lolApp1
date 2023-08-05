package com.example.lolapp.controller;

import com.example.lolapp.entity.User;
import com.example.lolapp.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }

}
