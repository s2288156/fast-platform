package com.fp.user.service;

import com.fp.user.api.IUserService;
import com.fp.user.api.bo.UserBO;
import com.fp.user.dao.dataobject.UserDO;
import com.fp.user.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author wcy
 */
@Component
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    private static final BeanCopier copier = BeanCopier.create(UserBO.class, UserDO.class, false);

    @Override
    public String getUserName(String id) {
        Optional<UserDO> userOptional = userRepository.findById(id);
        return userOptional.map(UserDO::getUsername).orElse(null);
    }

    @Override
    public UserBO addUser(UserBO user) {
        UserDO userDO = new UserDO();
        copier.copy(user, userDO, null);

        userRepository.save(userDO);
        user.setId(userDO.getId());
        return user;
    }
}
