package com.codexiodevcamp.jwtwebtokenapp.service;

import com.codexiodevcamp.jwtwebtokenapp.domain.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    boolean registerUser(User user);
}
