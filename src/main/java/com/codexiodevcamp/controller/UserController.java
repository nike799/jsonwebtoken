package com.codexiodevcamp.controller;

import com.codexiodevcamp.demojsonwebtoken.domain.User;
import com.codexiodevcamp.demojsonwebtoken.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
       return this.userService.saveUser(user);
    }

    @GetMapping("/get")
    public User getUser(HttpServletRequest request) {
        Long userId = (Long) request.getAttribute("id");
        return userService.getUser(userId);
    }
}
