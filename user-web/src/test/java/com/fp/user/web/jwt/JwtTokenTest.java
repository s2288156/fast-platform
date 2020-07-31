package com.fp.user.web.jwt;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Base64;

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
        log.warn("shareKey = {}", Base64.getEncoder().encodeToString(shareKey));
        log.warn("shareKey = {}", Base64.getEncoder().encodeToString(shareKey));
        log.warn("shareKey = {}", Base64.getEncoder().encodeToString(shareKey));
        Payload payload = new Payload(payloadStr);
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        JWSSigner jwsSigner = new MACSigner(shareKey);
        jwsObject.sign(jwsSigner);
        log.warn("{}", jwsObject.serialize());
    }

    @SneakyThrows
    @Test
    void testJWS_RSA() {
        RSAKey rsaJWK = new RSAKeyGenerator(2048).keyID("123").generate();
        RSAKey rsaPublicJWK = rsaJWK.toPublicJWK();

        RSASSASigner signer = new RSASSASigner(rsaJWK);

        String content = "In RSA we trust!";
        JWSObject jwsObject = new JWSObject(
                new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(rsaJWK.getKeyID()).build(),
                new Payload(content)
        );

        jwsObject.sign(signer);

        String s = jwsObject.serialize();
        log.warn("serialize = {}", s);
        assertNotNull(s);

        JWSObject parseJwsObject = JWSObject.parse(s);

        RSASSAVerifier verifier = new RSASSAVerifier(rsaPublicJWK);
        assertTrue(parseJwsObject.verify(verifier));
        assertEquals(content, parseJwsObject.getPayload().toString());
    }
}