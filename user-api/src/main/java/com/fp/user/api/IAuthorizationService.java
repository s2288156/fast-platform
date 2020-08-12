package com.fp.user.api;

import com.fp.user.api.domain.bo.UserBO;
import com.fp.user.api.domain.dto.UserDTO;
import com.fp.user.api.domain.query.UserQuery;

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

}
