package com.fp.auth.domain.bo;

import com.fp.auth.domain.dataobject.RoleDO;
import com.fp.auth.domain.dataobject.UserDO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author wcy
 */
@Data
public class UserRolesBO {

    private String id;

    private String username;

    private String email;

    private String phone;

    /**
     * 姓名
     **/
    private String name;

    private List<RoleDO> roleList;

    public static UserRolesBO assembleFor(UserDO userDO, List<RoleDO> roleList) {
        UserRolesBO userRolesBO = new UserRolesBO();
        BeanUtils.copyProperties(userDO, userRolesBO);
        userRolesBO.setRoleList(roleList);
        return userRolesBO;
    }
}
