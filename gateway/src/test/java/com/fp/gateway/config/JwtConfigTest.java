package com.fp.gateway.config;

import com.fp.tool.util.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wcy
 */
@Slf4j
@SpringBootTest
class JwtConfigTest {

    @Test
    void testJwt() {
        String aaa = JWTUtils.sign("aaa");
        log.info("{}", aaa);
    }
}