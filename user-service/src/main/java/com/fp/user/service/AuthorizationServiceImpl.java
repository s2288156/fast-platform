package com.fp.user.service;

import com.fp.tool.ex.BizException;
import com.fp.tool.ex.ResultCodeEnum;
import com.fp.user.api.IAuthorizationService;
import com.fp.user.api.domain.bo.UserBO;
import com.fp.user.api.domain.dto.UserDTO;
import com.fp.user.api.domain.query.UserQuery;
import com.fp.user.dao.dataobject.UserDO;
import com.fp.user.dao.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author wcy
 */
@Component
public class AuthorizationServiceImpl implements IAuthorizationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserBO login(UserQuery userQuery) {
        UserDO userDO = new UserDO();
        userDO.setUsername(userQuery.getUsername());
        userDO.setPassword(userQuery.getPassword());
        Optional<UserDO> optionalUserDO = userRepository.findOne(Example.of(userDO));
        return null;
    }

    @Override
    public UserDTO register(UserDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new BizException(ResultCodeEnum.USERNAME_EXISTS);
        }
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userDTO, userDO);
        userRepository.save(userDO);
        return userDTO;
    }
}
