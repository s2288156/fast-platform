package com.fp.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fp.auth.dao.mapper.UserMapper;
import com.fp.auth.domain.dataobject.UserDO;
import com.fp.auth.service.IAuthorizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wcy
 */
@Slf4j
@Component
public class AuthorizationServiceImpl implements IAuthorizationService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDO> allUser() {
        return userMapper.selectList(new LambdaQueryWrapper<>());
    }
}
