package com.fp.user.web.jwt;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wcy
 */
@Slf4j
class JwtTokenTest {

    @SneakyThrows
    @Test
    void testGenerateTokenByHMAC() {
        JWSHeader jwsHeader = new JWSHeader.Builder(JWSAlgorithm.HS256)
                .type(JOSEObjectType.JWT)
                .build();
        String payloadStr = "hello world";
        byte[] shareKey = new byte[32];
        new SecureRandom().nextBytes(shareKey);
        log.warn("shareKey = {}", new String(shareKey));
        Payload payload = new Payload(payloadStr);
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        JWSSigner jwsSigner = new MACSigner(shareKey);
        jwsObject.sign(jwsSigner);
        log.warn("{}", jwsObject.serialize());
    }
}