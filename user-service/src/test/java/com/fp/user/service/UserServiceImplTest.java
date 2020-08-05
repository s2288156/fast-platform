package com.fp.user.service;

import com.fp.user.api.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wcy
 */
@Slf4j
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private IUserService userService;

    @Test
    void getUserName() {
        log.info(">>>>>>>>>>>>>>>>>> testGetUserName");
        String userName = userService.getUserName("319648562566664192");
        assertNotNull(userName);
    }

    @Test
    void addUser() {
    }
}