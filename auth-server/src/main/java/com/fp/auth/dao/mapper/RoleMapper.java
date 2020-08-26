package com.fp.auth.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fp.auth.domain.dataobject.RoleDO;

import java.util.List;

/**
 * @author wcy
 */
public interface RoleMapper extends BaseMapper<RoleDO> {

    List<RoleDO> listUserRoles(String userId);

    List<String> listUserRoleName(String userId);

}
