package com.fp.security.config;

import com.fp.security.domain.JwtPayload;
import com.fp.tool.RestResult;
import com.fp.tool.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
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
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author wcy
 */
@Slf4j
@Configuration
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        User principal = (User) authentication.getPrincipal();
        JwtPayload payload = assembleForUser(principal);

        String token = payload.jwtSign();
        String accessToken = UUID.randomUUID().toString();

        stringRedisTemplate.opsForValue().set(accessToken, token, 6, TimeUnit.HOURS);

        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        httpServletResponse.setHeader("accessToken", accessToken);
        httpServletResponse.getWriter().write(JsonUtils.toJson(RestResult.success()));
    }

    private JwtPayload assembleForUser(User user) {
        Collection<GrantedAuthority> authorities = user.getAuthorities();
        log.info("authorities = {}", authorities);

        JwtPayload payload = new JwtPayload();
        payload.setRolesForAuthority(authorities);
        payload.setUsername(user.getUsername());
        return payload;
    }
}
