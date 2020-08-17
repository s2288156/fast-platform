package com.fp.user.service;

import com.fp.user.dao.domain.dataobject.UserDO;
import com.fp.user.dao.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wcy
 */
@Slf4j
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testOne() {
        UserDO userQuery = new UserDO();
        userQuery.setUsername("zhangsan");
        userQuery.setPassword("123456");
        Optional<UserDO> one = userRepository.findOne(Example.of(userQuery));
        assertTrue(one.isPresent());
        log.info("{}", one.get());
    }
}