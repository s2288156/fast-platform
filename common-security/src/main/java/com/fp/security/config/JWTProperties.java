package com.fp.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author wcy
 */
@Component
public class JWTProperties {

    public static String publicKey;

    public static String privateKey;

    @Value("${jwt.rsa.public-key}")
    public void setPublicKey(String publicKey) {
        JWTProperties.publicKey = publicKey;
    }

    @Value("${jwt.rsa.private-key}")
    public void setPrivateKey(String privateKey) {
        JWTProperties.privateKey = privateKey;
    }
}
