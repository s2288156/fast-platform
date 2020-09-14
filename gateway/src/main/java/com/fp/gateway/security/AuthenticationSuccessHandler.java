package com.fp.gateway.security;

import com.fp.tool.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.WebFilterChainServerAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author wcy
 */
@Slf4j
@Component
public class AuthenticationSuccessHandler extends WebFilterChainServerAuthenticationSuccessHandler {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 如果授权成功，则将accessToken返回给前端
     */
    @Override
    public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        JwtPayload payload = JwtPayload.assembleForUser(user);

        // 生成jwt，并放入accessToken中，redis中做缓存
        String jwt = payload.jwtSign();
        String accessToken = UUID.randomUUID().toString();
        stringRedisTemplate.opsForValue().set(accessToken, jwt, 6, TimeUnit.HOURS);
        // header返回accessToken
        ServerHttpResponse response = webFilterExchange.getExchange().getResponse();
        HttpHeaders headers = response.getHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, accessToken);

        DataBuffer bodyDataBuffer = WebConfigUtils.getDataBuffer(response, RestResult.success());
        return response.writeWith(Mono.just(bodyDataBuffer));
    }

}
