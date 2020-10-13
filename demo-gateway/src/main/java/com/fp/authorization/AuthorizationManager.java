package com.fp.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * 鉴权管理器，用于判断是否有资源的访问权限
 *
 * @author wcy
 */
@Component
public class AuthorizationManager implements ReactiveAuthenticationManager {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        return null;
    }
}
