package com.fp.user.web.domain.vo;

import com.fp.user.common.enums.SexEnum;
import com.fp.user.web.domain.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author wcy
 */
@Data
public class UserVO implements Serializable {
    private static final long serialVersionUID = -5898676128178450159L;

    private String username;

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
    private SexEnum sex;
}
