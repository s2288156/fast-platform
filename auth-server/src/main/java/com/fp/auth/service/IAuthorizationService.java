package com.fp.auth.service;


import com.fp.auth.domain.dataobject.UserDO;

import java.util.List;

/**
 * @author wcy
 */
public interface IAuthorizationService {

    List<UserDO> allUser();

}
