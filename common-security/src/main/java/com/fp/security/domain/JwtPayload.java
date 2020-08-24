package com.fp.security.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author wcy
 */
@Data
public class JwtPayload implements Serializable {
    private static final long serialVersionUID = -6120767156216018241L;

    /**
     * joins for “,”
     */
    private String roles;

    public void setRolesForAuthority(Collection<GrantedAuthority> authorities) {
        this.roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
    }
}
