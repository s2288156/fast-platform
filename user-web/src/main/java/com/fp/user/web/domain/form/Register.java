package com.fp.user.web.domain.form;

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
}
