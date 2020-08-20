package com.fp.user.dao.domain.dataobject;

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
