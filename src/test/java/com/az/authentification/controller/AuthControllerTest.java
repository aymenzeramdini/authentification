package com.az.authentification.controller;

import com.az.authentification.config.JwtService;
import com.az.authentification.model.AuthRequest;
import com.az.authentification.model.AuthResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private AuthController authController;

    @Test
    void login_shouldReturnToken() {
        AuthRequest request = new AuthRequest();
        String token = "jwt.token.here";
        when(jwtService.generateToken(request.getUsername())).thenReturn(token);

        ResponseEntity<AuthResponse> response = authController.login(request);

        assertEquals("200 OK", response.getStatusCode().toString());
        assertEquals(token, response.getBody().getToken());
        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
        verify(jwtService).generateToken(request.getUsername());
    }
}