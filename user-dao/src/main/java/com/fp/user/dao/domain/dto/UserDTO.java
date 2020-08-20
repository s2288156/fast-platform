package com.fp.user.dao.domain.dto;

import com.fp.user.common.enums.SexEnum;
import com.fp.user.dao.domain.dataobject.UserDO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

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

    public UserDO generatorDO() {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(this, userDO);
        return userDO;
    }
}
