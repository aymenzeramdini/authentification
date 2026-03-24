package com.az.authentification.config;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.junit.jupiter.api.Assertions.*;

class SecurityConfigTest {

    private final SecurityConfig securityConfig = new SecurityConfig(null); // jwtAuthFilter can be null for this test

    @Test
    void passwordEncoder_shouldEncodeAndMatch() {
        PasswordEncoder encoder = securityConfig.passwordEncoder();
        String rawPassword = "password";
        String encoded = encoder.encode(rawPassword);
        assertNotNull(encoded);
        assertTrue(encoder.matches(rawPassword, encoded));
        assertFalse(encoder.matches("wrong", encoded));
    }
}