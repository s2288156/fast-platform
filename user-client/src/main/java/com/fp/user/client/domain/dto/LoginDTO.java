package com.fp.user.client.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wcy
 */
@Data
public class LoginDTO implements Serializable {
    private static final long serialVersionUID = 4044999250638350325L;

    private String username;

    private String password;
}
