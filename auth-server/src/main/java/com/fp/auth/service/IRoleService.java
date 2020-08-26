package com.fp.auth.service;

import java.util.List;

/**
 * @author wcy
 */
public interface IRoleService {

    boolean existRoles(List<String> roleIds);
}
