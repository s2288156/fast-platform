package com.fp.auth.domain.vo;


import com.fp.auth.domain.bo.UserBO;
import com.fp.auth.domain.bo.UserRolesBO;
import com.fp.auth.enums.SexEnum;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

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

    private List<RoleVO> roleList;

    private List<String> roleNames;

    public static UserVO assembleFor(UserRolesBO userRolesBO) {
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userRolesBO, userVO);
        if (!CollectionUtils.isEmpty(userRolesBO.getRoleList())) {
            List<RoleVO> roleVOS = userRolesBO.getRoleList().stream().map(roleDO -> {
                RoleVO roleVO = new RoleVO();
                BeanUtils.copyProperties(roleDO, roleVO);
                return roleVO;
            }).collect(Collectors.toList());
            userVO.setRoleList(roleVOS);
        }
        return userVO;
    }

    public static UserVO assembleFor(UserBO userBO) {
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userBO, userVO);
        return userVO;
    }
}
