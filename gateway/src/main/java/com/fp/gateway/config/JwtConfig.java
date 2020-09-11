package com.fp.gateway.config;

import com.fp.tool.util.JWTUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author wcy
 */
@Component
public class JwtConfig {

    @Value("${jwt.rsa.public-key}")
    public String publicKey;

    @Value("${jwt.rsa.private-key}")
    public String privateKey;

    @Bean
    public JWTUtils jwtUtils() {
        return new JWTUtils(privateKey, publicKey);
    }
}
