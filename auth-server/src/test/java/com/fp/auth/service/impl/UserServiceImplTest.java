package com.fp.auth.service.impl;

import com.fp.auth.domain.bo.UserRolesBO;
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
    private UserServiceImpl userService;

    @Test
    void detailById() {
        String uid = "327340418075201536";
        UserRolesBO userRolesBO = userService.detailById(uid);
        assertNotNull(userRolesBO);
        assertNotNull(userRolesBO.getRoleList());
        log.warn("{}", userRolesBO);
    }
}