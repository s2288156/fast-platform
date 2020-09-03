package com.fp.auth.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fp.auth.dao.mapper.RoleMapper;
import com.fp.auth.domain.dataobject.RoleDO;
import com.fp.auth.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wcy
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public boolean existRoles(List<String> roleIds) {
        Integer rolesCount = roleMapper.selectCount(new LambdaQueryWrapper<RoleDO>().in(RoleDO::getId, roleIds));
        return rolesCount == roleIds.size();
    }

    @Override
    public List<RoleDO> getUserRoles(String userId) {
        return roleMapper.listUserRoles(userId);
    }
}
