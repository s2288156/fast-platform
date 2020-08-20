package com.fp.user.service;

import com.fp.user.dao.domain.dto.UserDTO;

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

    boolean existForUsername(String username);

}
