package com.fp.auth.doman.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author wcy
 */
@Data
public class AuthUserDTO implements Serializable {

    private static final long serialVersionUID = 1066130750619138101L;

    private String username;

    private String password;

    private List<String> roleNames;
}
