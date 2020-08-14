package com.fp.user.service.domain;

import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author wcy
 */
public class CustomAuthority implements GrantedAuthority {

    @Setter
    private String autority;

    @Override
    public String getAuthority() {
        return null;
    }
}
