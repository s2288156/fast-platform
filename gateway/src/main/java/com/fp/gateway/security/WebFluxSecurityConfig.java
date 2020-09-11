package com.fp.gateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author wcy
 */
@EnableWebFluxSecurity
public class WebFluxSecurityConfig {

    @Bean
    public SecurityWebFilterChain webFluxSecurityFilterChain(ServerHttpSecurity http) throws Exception{
        http
                .authorizeExchange()
                .pathMatchers("/auth/login", "/auth/register", "/auth/logout").permitAll()
                .pathMatchers(HttpMethod.OPTIONS).permitAll()
                .anyExchange().authenticated()
                .and()
                .httpBasic()
                .and()
                .formLogin().loginPage("/auth/login")
                .authenticationSuccessHandler(new AuthenticationSuccessHandler())
                .authenticationFailureHandler(null)
                .and().exceptionHandling()
                .authenticationEntryPoint(null)
                .and().csrf().disable()
                .logout().disable();

        return http.build();
    }
}
