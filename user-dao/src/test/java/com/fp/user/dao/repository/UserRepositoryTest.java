package com.fp.user.dao.repository;

import com.fp.user.common.enums.SexEnum;
import com.fp.user.dao.NoneWebTest;
import com.fp.user.dao.domain.dataobject.RoleDO;
import com.fp.user.dao.domain.dataobject.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    @Transactional
    @Test
    void testUserManyToManyRole() {
        UserDO userDO = new UserDO();
        userDO.setUsername("aaaaaaa");
        userDO.setPassword("11111111");
        RoleDO roleDO = new RoleDO();
        roleDO.setName("Admin");
        List<RoleDO> roleDOList = new ArrayList<>();
        roleDOList.add(roleDO);

        userDO.setRoleList(roleDOList);
        userRepository.save(userDO);
    }
}