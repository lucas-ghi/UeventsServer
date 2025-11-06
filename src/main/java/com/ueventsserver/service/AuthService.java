package com.ueventsserver.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Service
public class AuthService {
    private final JwtEncoder encoder;

    public AuthService(JwtEncoder encoder) {
        this.encoder = encoder;
    }

    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("UEventsServer") // Quem emitiu o token
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.HOURS)) // Expira em 1 hora
                .subject(authentication.getName()) // O username
                .build();

        // 3. Codifica e assina o token com a chave privada
        return this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
