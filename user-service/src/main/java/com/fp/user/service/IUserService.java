package com.fp.user.service;

import com.fp.user.dao.domain.dto.UserDTO;

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
     * @return 增加成功条数
     */
    int addRoles(List<String> roleIdList, String userId);

}
