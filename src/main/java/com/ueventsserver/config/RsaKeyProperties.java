package com.ueventsserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Configuration
@ConfigurationProperties(prefix = "rsa.key")
@Data
public class RsaKeyProperties {

    private String publicKey;
    private String privateKey;

    public RSAPublicKey getRsaPublicKey() {
        try {
            byte[] keyBytes = Base64.getDecoder().decode(this.publicKey);
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return (RSAPublicKey) kf.generatePublic(spec);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao carregar a chave pública RSA.", e);
        }
    }

    public RSAPrivateKey getRsaPrivateKey() {
        try {
            byte[] keyBytes = Base64.getDecoder().decode(this.privateKey);
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return (RSAPrivateKey) kf.generatePrivate(spec);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao carregar a chave privada RSA.", e);
        }
    }
}
