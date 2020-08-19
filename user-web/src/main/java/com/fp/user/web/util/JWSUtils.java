package com.fp.user.web.util;

import com.fp.tool.ex.ResultCodeEnum;
import com.fp.tool.ex.SysException;
import com.fp.tool.util.CertUtil;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import lombok.SneakyThrows;

import java.security.PrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @author wcy
 */
public class JWSUtils {

    private static CertUtil cert;
    private static PrivateKey priKey;
    private static RSAPublicKey pubKey;

    static {
        cert = new CertUtil();
        cert.initKeyStore("jwt.jks", "JKS", "123456");
        priKey = cert.getPriKey();
        pubKey = (RSAPublicKey) cert.getPubKey();
    }

    public static String sign(String json) {
        // 创建signer
        RSASSASigner signer = new RSASSASigner(priKey);

        JWSObject jwsObject = new JWSObject(
                new JWSHeader.Builder(JWSAlgorithm.RS256).build(),
                new Payload(json)
        );
        try {
            jwsObject.sign(signer);
        } catch (JOSEException e) {
            throw new SysException(ResultCodeEnum.SYS_EXECUTE_ERROR);
        }
        return jwsObject.serialize();
    }

    @SneakyThrows
    public static boolean verify(String token) {
        RSASSAVerifier verifier = new RSASSAVerifier(pubKey);
        JWSObject parseJwsObject = JWSObject.parse(token);
        return parseJwsObject.verify(verifier);
    }

    @SneakyThrows
    public static String getPayload(String token) {
        JWSObject parseJwsObject = JWSObject.parse(token);
        return parseJwsObject.getPayload().toString();
    }
}
