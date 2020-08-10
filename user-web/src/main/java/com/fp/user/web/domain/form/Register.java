package com.fp.user.web.domain.form;

import com.fp.user.dao.enums.SexEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wcy
 */
@Data
public class Register implements Serializable {

    private static final long serialVersionUID = 3631865043308111932L;

    private String username;

    private String email;

    private String password;

    private String phone;

    private String name;

    private Integer age;

    private SexEnum sex;
}
