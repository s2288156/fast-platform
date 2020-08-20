package com.fp.user.service;

import com.fp.user.dao.domain.dataobject.UserDO;
import com.fp.user.dao.domain.bo.UserBO;
import com.fp.user.dao.domain.dto.UserDTO;
import com.fp.user.dao.domain.query.UserQuery;

import java.util.List;

/**
 * @author wcy
 */
public interface IAuthorizationService {

    UserBO login(UserQuery userQuery);

    /**
     * 用户注册
     *
     * @param userDTO param
     * @return result
     */
    UserDTO register(UserDTO userDTO);

    List<UserDO> allUser();

}