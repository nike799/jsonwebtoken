package com.codexiodevcamp.demojsonwebtoken.service;

import com.codexiodevcamp.demojsonwebtoken.domain.User;
import com.codexiodevcamp.demojsonwebtoken.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private TokenService tokenService;

    @Autowired
    UserService(UserRepository userRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public String saveUser(User user) {
        User savedUser = userRepository.save(user);
        return tokenService.createToken(savedUser.getId());
    }
}
