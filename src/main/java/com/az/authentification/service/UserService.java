package com.az.authentification.service;

import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Service
public class UserService {
    public UserDetails loadUser(String username) {
        return User.builder()
                .username(username)
                .password("password")
                .roles("USER")
                .build();
    }
}
