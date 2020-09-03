package com.fp.auth.service;

import com.fp.auth.domain.dataobject.RoleDO;
import com.fp.auth.domain.form.InsertRole;

import java.util.List;

/**
 * @author wcy
 */
public interface IRoleService {

    boolean existRoles(List<String> roleIds);

    List<RoleDO> getUserRoles(String userId);

    int insert(InsertRole role);
}
