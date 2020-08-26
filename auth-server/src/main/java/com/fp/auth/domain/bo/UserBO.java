package com.fp.auth.domain.bo;

import lombok.Data;

/**
 * @author wcy
 */
@Data
public class UserBO {

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
