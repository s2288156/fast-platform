package com.fp.user.dao.mapper;

import com.fp.user.dao.NoneWebTest;
import com.fp.user.dao.domain.dataobject.UserDO;
import com.fp.user.dao.domain.dto.UserRolesDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wcy
 */
@Slf4j
public class UserMapperTest extends NoneWebTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void testAdd() {
        UserDO userDO = new UserDO();
        userDO.setUsername("aabbccaa");
        userDO.setPassword("112233");

        userMapper.insert(userDO);
    }

}
