package com.fp.auth.service;

import com.fp.auth.domain.dataobject.RoleDO;

import java.util.List;

/**
 * @author wcy
 */
public interface IRoleService {

    boolean existRoles(List<String> roleIds);

    List<RoleDO> getUserRoles(String userId);
}
