package com.fp.user.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fp.user.dao.domain.dataobject.RoleDO;

import java.util.List;

/**
 * @author wcy
 */
public interface RoleMapper extends BaseMapper<RoleDO> {

    List<RoleDO> listUserRoles(String userId);

    List<String> listUserRoleName(String userId);

}
