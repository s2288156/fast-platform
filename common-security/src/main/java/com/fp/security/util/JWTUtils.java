package com.fp.security.util;

import com.fp.security.JWTProperties;
import com.fp.tool.ex.ResultCodeEnum;
import com.fp.tool.ex.SysException;
import com.fp.tool.secure.SecureUtil;
import com.fp.tool.secure.asymmetric.SignAlgorithm;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;

import java.security.PrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @author wcy
 */
public class JWTUtils {

    private static PrivateKey priKey;

    private static RSAPublicKey pubKey;

    private static RSASSASigner signer;

    private static RSASSAVerifier verifier;

    static {
        priKey = SecureUtil.generatePrivateKey(SignAlgorithm.SHA1withRSA, JWTProperties.privateKey);
        pubKey = (RSAPublicKey) SecureUtil.generatePublicKey(SignAlgorithm.SHA1withRSA, JWTProperties.publicKey);
        signer = new RSASSASigner(priKey);
        verifier = new RSASSAVerifier(pubKey);
    }

    public static String sign(String json) {
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

    public static boolean verify(String token) {
        try {
            JWSObject parseJwsObject = JWSObject.parse(token);
            return parseJwsObject.verify(verifier);
        } catch (Exception e) {
            throw new SysException(ResultCodeEnum.SYS_EXECUTE_ERROR);
        }
    }

    public static String getPayload(String token) {
        try {
            JWSObject parseJwsObject = JWSObject.parse(token);
            return parseJwsObject.getPayload().toString();
        } catch (Exception e) {
            throw new SysException(ResultCodeEnum.SYS_EXECUTE_ERROR);
        }
    }
}
