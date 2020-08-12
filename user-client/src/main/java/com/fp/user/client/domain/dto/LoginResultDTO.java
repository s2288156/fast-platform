package com.fp.user.client.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wcy
 */
@Data
public class LoginResultDTO implements Serializable {
    private static final long serialVersionUID = 6436665685012708396L;

    private String token;
}
