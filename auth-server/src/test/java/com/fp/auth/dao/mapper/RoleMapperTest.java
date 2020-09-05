package com.fp.auth.dao.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fp.auth.domain.dataobject.RoleDO;
import com.fp.mybatis.base.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wcy
 */
@Slf4j
@SpringBootTest
class RoleMapperTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    void listRoles() {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrent(1L);
        pageInfo.setSize(10L);
        Page<RoleDO> roleDOPage = roleMapper.pageRoles(pageInfo);
        log.info("{}", roleDOPage.getRecords());
    }
}