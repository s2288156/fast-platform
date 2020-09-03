package com.fp.auth.service;


import com.fp.auth.domain.bo.UserBO;
import com.fp.auth.domain.bo.UserRolesBO;
import com.fp.auth.domain.dto.UserDTO;
import com.fp.auth.domain.form.UserUpdate;

import java.util.List;

/**
 * @author wcy
 */
public interface IUserService {

    /**
     * 注册用户
     *
     * @param userDTO 用户信息
     */
    void register(UserDTO userDTO);

    /**
     * 查询此用户名是否存在
     *
     * @param username 用户名
     * @return true(存在), false(不存在)
     */
    boolean existForUsername(String username);

    /**
     * 为用户添加角色信息
     *
     * @param roleIdList 角色id
     * @param userId     user主键id
     * @return 增加成功条数
     */
    int addRoles(List<String> roleIdList, String userId);

    /**
     *
     * @param id
     * @return
     */
    UserRolesBO detailById(String id);

    UserBO update(UserUpdate userUpdate);
}
