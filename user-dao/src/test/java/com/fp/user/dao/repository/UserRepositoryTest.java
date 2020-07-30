package com.fp.user.dao.repository;

import com.fp.user.dao.NoneWebTest;
import com.fp.user.dao.dataobject.UserDO;
import com.fp.user.dao.enums.SexEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wcy
 */
@Slf4j
class UserRepositoryTest extends NoneWebTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void testSave() {
        UserDO userDO = new UserDO();
        userDO.setUsername("lao wang");
        userDO.setPassword("123456");
        userDO.setSex(SexEnum.MAN);
        UserDO save = userRepository.save(userDO);
        assertNotNull(save);
        assertNotNull(save.getId());
        log.info("{}", userDO);
    }
}