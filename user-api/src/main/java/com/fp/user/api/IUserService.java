package com.fp.user.api;

import com.fp.user.api.bo.UserBO;

/**
 * @author wcy
 */
public interface IUserService {

    String getUserName(String id);

    UserBO addUser(UserBO user);
}
