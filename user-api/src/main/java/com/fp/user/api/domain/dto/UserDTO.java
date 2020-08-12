package com.fp.user.api.domain.dto;

import com.fp.user.common.enums.SexEnum;
import lombok.Data;

/**
 * @author wcy
 */
@Data
public class UserDTO {

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
     * 0 - 男，1 - 女
     **/
    private SexEnum sex;
}
