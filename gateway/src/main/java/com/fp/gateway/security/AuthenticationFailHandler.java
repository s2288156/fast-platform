package com.fp.gateway.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fp.tool.RestResult;
import com.fp.tool.ex.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author wcy
 */
@Slf4j
@Component
public class AuthenticationFailHandler implements ServerAuthenticationFailureHandler {
    @Override
    public Mono<Void> onAuthenticationFailure(WebFilterExchange webFilterExchange, AuthenticationException e) {
        ServerHttpResponse response = webFilterExchange.getExchange().getResponse();

        ObjectMapper objectMapper = new ObjectMapper();
        byte[] dataBytes = {};
        try {
            dataBytes = objectMapper.writeValueAsBytes(RestResult.error(ResultCodeEnum.USER_LOGIN_ERROR));
        } catch (JsonProcessingException jsonProcessingException) {
            log.error("convert to bytes ex", jsonProcessingException);
        }
        DataBuffer bodyDataBuffer = response.bufferFactory().wrap(dataBytes);
        return response.writeWith(Mono.just(bodyDataBuffer));
    }
}
