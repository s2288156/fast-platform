package com.fp.security.config;

import com.fp.security.domain.JwtPayload;
import com.fp.security.util.JWTUtils;
import com.fp.tool.RestResult;
import com.fp.tool.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * @author wcy
 */
@Slf4j
@Configuration
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        User principal = (User) authentication.getPrincipal();
        Collection<GrantedAuthority> authorities = principal.getAuthorities();
        log.info("authority = {}", authorities);
        JwtPayload payload = new JwtPayload();
        payload.setRolesForAuthority(authorities);
        String token = JWTUtils.sign(JsonUtils.toJson(payload));
        log.warn("token = {}", token);
        redisTemplate.opsForValue().set(principal.getUsername(), token, 10, TimeUnit.MINUTES);
        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        httpServletResponse.setHeader("Authorization", token);
        httpServletResponse.getWriter().write(JsonUtils.toJson(RestResult.success()));
    }
}
