package com.ueventsserver.controller;

import com.ueventsserver.dto.LoginRequestDTO;
import com.ueventsserver.dto.LoginResponseDTO;
import com.ueventsserver.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final AuthService authService;

    public AuthController(AuthenticationManager authenticationManager, AuthService authService) {
        this.authenticationManager = authenticationManager;
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequest) {

        // 1. Tenta autenticar o usuário
        // Isso usa o UserDetailsService e o PasswordEncoder configurados no SecurityConfig
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        // 2. Se a autenticação for bem-sucedida, gera o token
        String token = authService.generateToken(authentication);

        // 3. Retorna o token para o cliente
        return LoginResponseDTO.builder()
                .token(token)
                .build();
    }
}
