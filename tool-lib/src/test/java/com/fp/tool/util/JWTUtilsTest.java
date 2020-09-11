package com.fp.tool.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wcy
 */
@Slf4j
class JWTUtilsTest {

    private String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCGsEHB6B5aGtIPF3qrx1P8E/i28kKMjGvIidUMu5HoPp9vQ6ytPMllEfGQV6cOSBK7h9wd2p09UZ1YlmbtKPs5nzd/jmk6OvDM5ziNi158xeq9UYbziNiV+s0HjlzYvmHIg63CiuTkBX5malT6Rkp5IZ6hTAFLPSUJCfeU467oe3NGhbWbNK8I1ywBDIyhyYuoofq1G0Hx3av35PozxLo2gGVr8nI6CI9H2rHknqO/7+DAnTVTfQxaPW8sd044+WJICNkYgHKYnniOWeAzFlAju9kl6j06qCi+XZ9YsN6GhX+3JEmY+6MKhvyb7cYiTjxzuapZXa62BCrPudA+T+zbAgMBAAECggEAAotV0qnl2OHk0fApmxEa3wopipss8qa8an9gDOuGKBL2xA1NN8CMNWKPY6CkQTrPT8eTOuUkT0I5bLD6pMQ/aqk9TSWNi1INtnEvukzFrim283iUygjtvneMY/Ymftmp0zXZlHE3Pa904c5kaI3nXj5qVrWu2JMBHhiYGrHqXe3fybwvHLXE/oDPaS5UWUmmnxkb7ePSTPXN2b2uTO3oIRSWIcFIdpqCHdDwBGjKry6bHSudTF53jJlilQHcXO34EyiUxwnmjzPg5nCGWCt3Hci/AY56Gb9qU4RCUtZW/eaT6MQCvW8SsilGg7kwyMfyn3Z1L/gXlKdFcfHt7FfDsQKBgQD0P90+z0z6ap4Ia+0jiXqvDlmIX+D3JVm1l2bxTR2Uc4bFtWuGLKXizIFQ8LGjxcyiFkNjom3TDvwwMQ3JnkEtzmmGlhlIWOTrrLMe2Ah31oIPG7jBx+mA5HGHNE90c2jDc/TFW/G62U3bfCWTzrAgF79iuMiOCfllhgqQ+2HmrQKBgQCNKw7ashTYitNrIcpP8kJ5MODXc3hJz2OJSdfFXOQjE3kqmhyW4ViZY/ijQlY780D17F8ZPiKts0gIT0Z+pqT5GfO0MMoXaP3Epc14ApbiYe7FA67davytCPK+lY/FAqiPu40V7hXfqme5HIjQutvbIxhWA5MnIo+Bn9YmZBR6pwKBgQCCKHZSPk4bNC269yiLw3tpRhBYKB/OFE1WA7SL6jhVH6s2OJNwEOLllW1kIJ/JUmLWDV8j/S7hRh8F314ljvvU2SZK3jni39w96u4ZBa6djeYI/xDZ0xqP4SzOjAW7XLT7UxOhCHosxBhFWkb8GSyqLX2DskzNxGruuxtuX0ewkQKBgGR2sCuTcKJqqeskMQaUMhptXpX15zUgEoYxtw0N/o233hMjehUmahc/vkLxgs1HYIOjpEoinitf23OOd2zKy707auRhlHD0lyTLml49+YNCjtpGtLt+2DOMmrRnW9mo+qzPnKhut8JlU0u5suRZFv3tC/Sqtp6zSc3GInFP6AMhAoGBAJmZv4TDLJTebWAAz6005H2yllg3jjtctvGykJtR1UYb2joo2glXwL4YpA8jZTugmPdsFunbp7UXrtuSwsjFCcn435sYA+nqfc0vrtldxgqW9gwpUt+vgkrBpzkERbVwQZQiDl0fQrggtZYMZltm9Uha2jh5BLaq5SrsrK78V2Ec";

    private String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhrBBwegeWhrSDxd6q8dT/BP4tvJCjIxryInVDLuR6D6fb0OsrTzJZRHxkFenDkgSu4fcHdqdPVGdWJZm7Sj7OZ83f45pOjrwzOc4jYtefMXqvVGG84jYlfrNB45c2L5hyIOtwork5AV+ZmpU+kZKeSGeoUwBSz0lCQn3lOOu6HtzRoW1mzSvCNcsAQyMocmLqKH6tRtB8d2r9+T6M8S6NoBla/JyOgiPR9qx5J6jv+/gwJ01U30MWj1vLHdOOPliSAjZGIBymJ54jlngMxZQI7vZJeo9Oqgovl2fWLDehoV/tyRJmPujCob8m+3GIk48c7mqWV2utgQqz7nQPk/s2wIDAQAB";

    @BeforeEach
    void setUp() {
        new JWTUtils(privateKey, publicKey);
    }

    @Test
    void sign() {
        User user = new User("laowang");
        String json = JsonUtils.toJson(user);
        String jwt = JWTUtils.sign(json);
        log.info("{}", jwt);
    }

    @Test
    void verify() {
    }

    @Test
    void getPayload() {
    }

    private class User implements Serializable {
        private static final long serialVersionUID = 5737260503603721953L;
        private String username;

        public User(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}