package com.codexiodevcamp.jwtwebtokenapp.service;

import com.codexiodevcamp.jwtwebtokenapp.constants.GlobalConstants;
import com.codexiodevcamp.jwtwebtokenapp.domain.entities.User;
import com.codexiodevcamp.jwtwebtokenapp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException(GlobalConstants.USER_NOT_FOUND);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getAuthorities()
        );
    }

    @Override
    public boolean registerUser(User user) {
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user) != null;
    }
}
