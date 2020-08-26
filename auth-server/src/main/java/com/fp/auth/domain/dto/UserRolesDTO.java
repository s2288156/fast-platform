package com.fp.auth.domain.dto;

import com.fp.auth.domain.dataobject.RoleDO;
import lombok.Data;

import java.util.List;

/**
 * @author wcy
 */
@Data
public class UserRolesDTO {

    private String id;

    private String username;

    private String email;

    private String phone;

    /**
     * 姓名
     **/
    private String name;

    private List<RoleDO> roleList;
}
