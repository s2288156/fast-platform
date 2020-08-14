package com.fp.user.service;

import com.fp.tool.ex.BizException;
import com.fp.tool.ex.ResultCodeEnum;
import com.fp.user.api.IAuthorizationService;
import com.fp.user.api.domain.bo.UserBO;
import com.fp.user.api.domain.dto.UserDTO;
import com.fp.user.api.domain.query.UserQuery;
import com.fp.user.dao.dataobject.UserDO;
import com.fp.user.dao.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author wcy
 */
@Slf4j
@Component
public class AuthorizationServiceImpl implements IAuthorizationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserBO login(UserQuery userQuery) {
        UserDO userDO = new UserDO();
        userDO.setUsername(userQuery.getUsername());
        Optional<UserDO> optionalUserDO = userRepository.findOne(Example.of(userDO));
        if (optionalUserDO.isPresent() && passwordEncoder.matches(userQuery.getPassword(), optionalUserDO.get().getPassword())) {
            UserBO userBO = new UserBO();
            BeanUtils.copyProperties(optionalUserDO.get(), userBO);
            return userBO;
        }
        throw new BizException(ResultCodeEnum.USER_LOGIN_ERROR);
    }

    private boolean verifyPassword(String password) {
        final String encodePassword = passwordEncoder.encode(password);
        return passwordEncoder.matches(password, encodePassword);
    }

    @Override
    public UserDTO register(UserDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new BizException(ResultCodeEnum.USERNAME_EXISTS);
        }
        UserDO userDO = new UserDO();
        userDO.setUsername(userDTO.getUsername());
        userDO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(userDO);
        return userDTO;
    }
}
