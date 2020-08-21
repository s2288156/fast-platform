package com.fp.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fp.tool.ex.BizException;
import com.fp.tool.ex.ResultCodeEnum;
import com.fp.user.dao.domain.dataobject.UserDO;
import com.fp.user.dao.domain.dto.UserDTO;
import com.fp.user.dao.mapper.UserMapper;
import com.fp.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author wcy
 */
@Component
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(UserDTO userDTO) {
        if (existForUsername(userDTO.getUsername())) {
            throw new BizException(ResultCodeEnum.USERNAME_EXISTS);
        }
        UserDO userDO = userDTO.generatorDO();
        userMapper.insert(userDO);
    }

    @Override
    public boolean existForUsername(String username) {
        UserDO userDO = userMapper.selectOne(
                new LambdaQueryWrapper<UserDO>()
                        .eq(UserDO::getUsername, username));
        return Objects.nonNull(userDO);
    }
}
