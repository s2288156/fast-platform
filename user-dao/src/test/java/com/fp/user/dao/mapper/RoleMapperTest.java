package com.fp.user.dao.mapper;

import com.fp.user.dao.NoneWebTest;
import com.fp.user.dao.domain.dataobject.RoleDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wcy
 */
@Slf4j
class RoleMapperTest extends NoneWebTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    void listUserRoles() {
        String userId = "325132950599618560";
        List<RoleDO> roleDOS = roleMapper.listUserRoles(userId);
        log.info("{}", roleDOS);
    }
}