package com.fp.auth.domain.bo;

import com.fp.auth.domain.dataobject.UserDO;
import com.fp.auth.enums.SexEnum;
import lombok.Data;
import org.springframework.beans.BeanUtils;

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
    private SexEnum sex;

    public static UserBO assembleFor(UserDO userDO) {
        UserBO userBO = new UserBO();
        BeanUtils.copyProperties(userDO, userBO);
        return userBO;
    }

}
