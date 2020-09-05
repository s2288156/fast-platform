package com.fp.auth.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fp.mybatis.base.PageInfo;
import com.fp.auth.dao.mapper.RoleMapper;
import com.fp.auth.domain.dataobject.RoleDO;
import com.fp.auth.domain.form.InsertRole;
import com.fp.auth.service.IRoleService;
import com.fp.tool.ex.BizException;
import com.fp.tool.ex.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public int insert(InsertRole role) {
        if (existForName(role.getName())) {
            throw new BizException(ResultCodeEnum.ROLE_EXIST);
        }
        return roleMapper.insert(role.convert2DO());
    }

    @Override
    public Page<RoleDO> pageRoles(PageInfo pageInfo) {

        return null;
    }

    private boolean existForName(String name) {
        Optional<RoleDO> optional = Optional.ofNullable(roleMapper.selectOne(new LambdaQueryWrapper<RoleDO>().eq(RoleDO::getName, name)));
        return optional.isPresent();
    }
}
