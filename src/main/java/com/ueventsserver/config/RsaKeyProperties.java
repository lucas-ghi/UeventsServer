package com.ueventsserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration
@ConfigurationProperties(prefix = "rsa.key")
@Data
public class RsaKeyProperties {

    private RSAPublicKey publicKey;
    private RSAPrivateKey privateKey;

    // NOTA: Para a injeção funcionar diretamente, você pode precisar
    // de um configurador que converta a string base64 para o objeto Key.
    // O Spring Boot 3+ (com Security 6+) faz isso automaticamente se a formatação estiver correta.
    // Se o erro persistir, você precisará de uma classe de utilitário para carregar as chaves.
}
