package com.fp.auth.domain.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fp.auth.enums.SexEnum;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author wcy-auto
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@TableName(autoResultMap = true, value = "t_user")
public class UserDO extends BaseEntity {

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
