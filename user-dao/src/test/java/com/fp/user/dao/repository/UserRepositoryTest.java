package com.fp.user.dao.repository;

import com.fp.user.dao.NoneWebTest;
import com.fp.user.dao.dataobject.UserDO;
import com.fp.user.common.enums.SexEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

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

    @Test
    void testCRUD() {
        UserDO userDO = new UserDO();
        String username = "lao wang";
        String password = "123456";
        userDO.setUsername(username);
        userDO.setPassword(password);
        userDO.setSex(SexEnum.MAN);
        UserDO save = userRepository.save(userDO);

        String id = save.getId();
        assertNotNull(id);
        String email = "123@1123.com";
        Optional<UserDO> searchUserOptional = userRepository.findById(id);
        assertTrue(searchUserOptional.isPresent());
        UserDO userDOSearch = searchUserOptional.get();
        assertNull(userDOSearch.getEmail());
        userDOSearch.setEmail(email);

        userRepository.save(userDOSearch);

        assertEquals(userRepository.findById(id).get().getEmail(), email);

        userRepository.deleteById(id);

        Optional<UserDO> deletedOptional = userRepository.findById(id);
        assertFalse(deletedOptional.isPresent());
    }
}