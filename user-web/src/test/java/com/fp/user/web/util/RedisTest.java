package com.fp.user.web.util;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author wcy
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @SneakyThrows
    @Test
    void testSetGet() {
        redisTemplate.opsForValue().set("addd", "xxxx", 3, TimeUnit.SECONDS);
        String addd = redisTemplate.opsForValue().get("addd");
        System.out.println(addd);
        TimeUnit.SECONDS.sleep(5);

        String addd1 = redisTemplate.opsForValue().get("addd");
        System.out.println(addd1);
    }
}
