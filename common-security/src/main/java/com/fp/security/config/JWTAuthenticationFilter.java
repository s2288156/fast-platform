package com.fp.security.config;

import com.fp.security.domain.JwtPayload;
import com.fp.security.util.JWTUtils;
import com.fp.tool.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wcy
 */
@Slf4j
@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private static final String TOKEN_PREFIX = "Bearer ";

    public static final String AUTHORIZATION_HEADER = "Authorization";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String accessToken = resolveToken(httpServletRequest);

        if (StringUtils.isBlank(accessToken)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        try {
            String jwt = stringRedisTemplate.opsForValue().get(accessToken);
            if (StringUtils.isNotBlank(jwt) && JWTUtils.verify(jwt)) {
                String payload = JWTUtils.getPayload(jwt);
                JwtPayload jwtPayload = JsonUtils.fromJson(payload, JwtPayload.class);
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(null, null, AuthorityUtils.commaSeparatedStringToAuthorityList(jwtPayload.getRoles()));
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        } catch (Exception e) {
            log.error("JWTAuthenticationFilter:", e);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    /**
     * Get token from header.
     */
    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.isNotBlank(bearerToken) && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.substring(7);
        }
        return null;
    }

}
