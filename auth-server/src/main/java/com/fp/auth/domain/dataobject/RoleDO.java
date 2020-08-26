package com.fp.auth.domain.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(autoResultMap = true, value = "t_role")
public class RoleDO extends BaseEntity {

    /**
     * 角色名
     **/
    private String name;

    /**
     * 详细说明
     **/
    private String description;

}
