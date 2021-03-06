package com.fp.auth.service.impl;

import com.fp.auth.dao.mapper.UserMapper;
import com.fp.auth.domain.dataobject.UserDO;
import com.fp.auth.enums.SexEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wcy
 */
@Slf4j
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    void testAdd() {
        UserDO userDO = new UserDO();
        userDO.setUsername("aaa");
        userDO.setPassword("123");
        userDO.setSex(SexEnum.MAN);
        userMapper.insert(userDO);
    }
}