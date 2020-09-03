package com.fp.auth.domain.form;

import com.fp.auth.domain.dataobject.UserDO;
import com.fp.auth.enums.SexEnum;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author wcy
 */
@Data
public class UserUpdate implements Serializable {

    private static final long serialVersionUID = 3631865043308111932L;

    private String id;

    private String email;

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
    private String sex;

    public SexEnum getSex() {
        return SexEnum.valueOf(this.sex);
    }

    public UserDO convert2DO() {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(this, userDO);
        return userDO;
    }
}
