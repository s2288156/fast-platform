package com.fp.user.dao.domain.dto;

import com.fp.user.dao.domain.dataobject.RoleDO;
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
