package com.az.authentification.config;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JwtServiceTest {

    private final JwtService jwtService = new JwtService();

    @Test
    void generateToken_shouldReturnToken() {
        String username = "testuser";
        String token = jwtService.generateToken(username);
        assertNotNull(token);
        assertTrue(token.length() > 0);
    }

    @Test
    void extractUsername_shouldReturnUsername() {
        String username = "testuser";
        String token = jwtService.generateToken(username);
        String extracted = jwtService.extractUsername(token);
        assertEquals(username, extracted);
    }

    @Test
    void extractUsername_withInvalidToken_shouldThrowException() {
        String invalidToken = "invalid.token.here";
        assertThrows(Exception.class, () -> jwtService.extractUsername(invalidToken));
    }
}