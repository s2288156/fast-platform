package com.fp.tool.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wcy
 */
@Slf4j
@SpringBootTest
class CertUtilTest {

    @Test
    void initKeyStore() {
        CertUtil certUtil = new CertUtil();
        certUtil.initKeyStore("jwt.jks", "JKS", "123456");
        PublicKey pubKey = certUtil.getPubKey();
        PrivateKey priKey = certUtil.getPriKey();
        log.info("pri = {}, pub = {}", Base64.getEncoder().encodeToString(priKey.getEncoded()),
                Base64.getEncoder().encodeToString(pubKey.getEncoded()));
    }
}