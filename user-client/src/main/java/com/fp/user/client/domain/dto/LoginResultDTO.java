package com.fp.user.client.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wcy
 */
@Data
public class LoginResultDTO implements Serializable {
    private static final long serialVersionUID = 6436665685012708396L;

    private String username;

    private String email;

    private String password;

    private String phone;

    /**
     * 姓名
     **/
    private String name;

    /**
     * 年龄
     **/
    private Integer age;

    /**
     * 性别
     **/
    private String sex;
}
