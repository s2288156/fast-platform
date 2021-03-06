package com.fp.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fp.auth.dao.mapper.UserMapper;
import com.fp.auth.dao.mapper.UserRoleMapper;
import com.fp.auth.domain.bo.UserBO;
import com.fp.auth.domain.dataobject.UserDO;
import com.fp.auth.domain.dataobject.UserRoleDO;
import com.fp.auth.domain.dto.UserDTO;
import com.fp.auth.domain.form.UserUpdate;
import com.fp.auth.service.IRoleService;
import com.fp.auth.service.IUserService;
import com.fp.tool.ex.BizException;
import com.fp.tool.ex.ResultCodeEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wcy
 */
@Component
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private IRoleService roleService;

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

    @Override
    public int addRoles(List<String> roleIdList, String userId) {
        UserDO userDO = userMapper.selectById(userId);
        if (userDO == null) {
            throw new BizException(ResultCodeEnum.USERNAME_NOT_EXISTS);
        }
        if (!roleService.existRoles(roleIdList)) {
            throw new BizException(ResultCodeEnum.INVALID_INPUT);
        }
        AtomicInteger num = new AtomicInteger();
        roleIdList.forEach(roleId -> {
            UserRoleDO userRoleDO;
            if (!existUserRole(userId, roleId)) {
                userRoleDO = new UserRoleDO()
                        .setUserId(userId)
                        .setRoleId(roleId);
                num.addAndGet(userRoleMapper.insert(userRoleDO));

            }
        });
        return num.get();
    }

    @Override
    public UserBO update(UserUpdate userUpdate) {
        userMapper.updateById(userUpdate.convert2DO());
        UserDO userDO = userMapper.selectById(userUpdate.getId());
        return UserBO.assembleFor(userDO);
    }

    @Override
    public UserBO selectUserById(String id) {
        Optional<UserDO> optionalUserDO = Optional.ofNullable(userMapper.selectById(id));
        if (optionalUserDO.isPresent()) {
            UserBO userBO = new UserBO();
            BeanUtils.copyProperties(optionalUserDO.get(), userBO);
            return userBO;
        }
        throw new BizException(ResultCodeEnum.USER_NOT_EXISTS);
    }

    /**
     * t_user_role表存在关联信息
     */
    private boolean existUserRole(String userId, String roleId) {
        UserRoleDO userRoleDO = userRoleMapper.selectOne(new LambdaQueryWrapper<UserRoleDO>()
                .eq(UserRoleDO::getRoleId, roleId)
                .eq(UserRoleDO::getUserId, userId)
        );
        return Objects.nonNull(userRoleDO);
    }

}
