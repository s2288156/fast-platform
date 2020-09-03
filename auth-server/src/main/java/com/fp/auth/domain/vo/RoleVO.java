package com.fp.auth.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wcy
 */
@Data
public class RoleVO implements Serializable {

    private static final long serialVersionUID = -5239475776683650827L;
    /**
     * 角色名
     **/
    private String name;

    /**
     * 详细说明
     **/
    private String description;
}
