package com.fp.auth.dao.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fp.mybatis.base.PageInfo;
import com.fp.auth.domain.dataobject.RoleDO;

import java.util.List;

/**
 * @author wcy
 */
public interface RoleMapper extends BaseMapper<RoleDO> {

    List<RoleDO> listUserRoles(String userId);

    List<String> listUserRoleName(String userId);

    default Page<RoleDO> pageRoles(PageInfo pageInfo) {
        Page<RoleDO> page = pageInfo.convert2Page(RoleDO.class);
        this.selectPage(page, new LambdaQueryWrapper<>());
        return page;
    }
}
