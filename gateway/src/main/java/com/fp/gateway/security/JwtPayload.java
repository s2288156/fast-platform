package com.fp.gateway.security;

import com.fp.tool.util.JWTUtils;
import com.fp.tool.util.JsonUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author wcy
 */
@Slf4j
@Data
public class JwtPayload implements Serializable {
    private static final long serialVersionUID = -6120767156216018241L;

    /**
     * joins for “,”
     */
    private String roles;

    private String username;

    public void setRolesForAuthority(Collection<GrantedAuthority> authorities) {
        this.roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
    }

    public String jwtSign() {
        return JWTUtils.sign(JsonUtils.toJson(this));
    }

    public static JwtPayload assembleForUser(User user) {
        Collection<GrantedAuthority> authorities = user.getAuthorities();
        log.info("authorities = {}", authorities);

        JwtPayload payload = new JwtPayload();
        payload.setRolesForAuthority(authorities);
        payload.setUsername(user.getUsername());
        return payload;
    }
}
