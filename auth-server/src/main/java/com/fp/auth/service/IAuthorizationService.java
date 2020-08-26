package com.fp.auth.service;



import com.fp.auth.domain.bo.UserBO;
import com.fp.auth.domain.dataobject.UserDO;
import com.fp.auth.domain.query.UserQuery;

import java.util.List;

/**
 * @author wcy
 */
public interface IAuthorizationService {

    UserBO login(UserQuery userQuery);

    List<UserDO> allUser();

}
