package com.fp.user.dao.dataobject;

import com.fp.user.common.enums.SexEnum;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * @author wcy-auto
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user")
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
    @Column(columnDefinition = "tinyint(1)")
    private Integer age;

    /**
     * 0 - 男，1 - 女
     **/
    @Enumerated
    @Column(columnDefinition = "tinyint(1)")
    private SexEnum sex;

}
