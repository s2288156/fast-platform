package com.fp.gateway.security;

import com.fp.tool.RestResult;
import com.fp.tool.ex.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.authentication.HttpBasicServerAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author wcy
 */
@Slf4j
@Component
public class CustomHttpBasicServerAuthenticationEntryPoint extends HttpBasicServerAuthenticationEntryPoint {
    @Override
    public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException e) {
        ServerHttpResponse response = exchange.getResponse();
        DataBuffer bodyDataBuffer = WebConfigUtils.getDataBuffer(response, RestResult.error(ResultCodeEnum.USER_LOGIN_ERROR));
        return response.writeWith(Mono.just(bodyDataBuffer));
    }
}
