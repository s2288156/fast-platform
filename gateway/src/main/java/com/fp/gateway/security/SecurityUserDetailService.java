package com.fp.gateway.security;

import com.fp.auth.api.IUserApi;
import com.fp.auth.doman.dto.AuthUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wcy
 */
@Component
public class SecurityUserDetailService implements ReactiveUserDetailsService {

    @Autowired
    private IUserApi userApi;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        AuthUserDTO authUserDTO = userApi.selectAuthUser(username);
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = authUserDTO.getRoleNames().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        User user = new User(authUserDTO.getUsername(), authUserDTO.getPassword(), simpleGrantedAuthorities);
        return Mono.just(user);
    }
}
