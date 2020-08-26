package com.fp.auth.domain.form;

import com.fp.auth.enums.SexEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author wcy
 */
@Data
public class Register implements Serializable {

    private static final long serialVersionUID = 3631865043308111932L;

    @NotBlank(message = "用户名不能为空")
    private String username;

    private String email;

    @NotBlank(message = "密码不能为空")
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
