package com.fp.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fp.tool.ex.BizException;
import com.fp.tool.ex.ResultCodeEnum;
import com.fp.user.dao.domain.dataobject.RoleDO;
import com.fp.user.dao.mapper.UserMapper;
import com.fp.user.service.IAuthorizationService;
import com.fp.user.dao.domain.bo.UserBO;
import com.fp.user.dao.domain.dto.UserDTO;
import com.fp.user.dao.domain.query.UserQuery;
import com.fp.user.dao.domain.dataobject.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author wcy
 */
@Slf4j
@Component
public class AuthorizationServiceImpl implements IAuthorizationService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBO login(UserQuery userQuery) {
        UserDO userDO = new UserDO();
        userDO.setUsername(userQuery.getUsername());
        // TODO: 2020/8/20 补充dao逻辑
//        Optional<UserDO> optionalUserDO = userRepository.findOne(Example.of(userDO));
//        if (optionalUserDO.isPresent() && passwordEncoder.matches(userQuery.getPassword(), optionalUserDO.get().getPassword())) {
//            UserBO userBO = new UserBO();
//            BeanUtils.copyProperties(optionalUserDO.get(), userBO);
//            return userBO;
//        }
        throw new BizException(ResultCodeEnum.USER_LOGIN_ERROR);
    }

    private boolean verifyPassword(String password) {
        final String encodePassword = passwordEncoder.encode(password);
        return passwordEncoder.matches(password, encodePassword);
    }


    @Override
    public List<UserDO> allUser() {
        return userMapper.selectList(new LambdaQueryWrapper<>());
    }
}
