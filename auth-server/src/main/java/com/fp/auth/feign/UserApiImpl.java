package com.fp.auth.feign;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fp.auth.api.IUserApi;
import com.fp.auth.dao.mapper.RoleMapper;
import com.fp.auth.dao.mapper.UserMapper;
import com.fp.auth.domain.dataobject.UserDO;
import com.fp.auth.doman.dto.AuthUserDTO;
import com.fp.tool.ex.BizException;
import com.fp.tool.ex.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wcy
 */
@RestController
public class UserApiImpl implements IUserApi {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public AuthUserDTO selectAuthUser(String username) {
        UserDO userDO = userMapper.selectOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getUsername, "admin"));
        if (userDO == null) {
            throw new BizException(ResultCodeEnum.USER_LOGIN_ERROR);
        }
        List<String> roleNameList = roleMapper.listUserRoleName(userDO.getId());
        AuthUserDTO authUserDTO = new AuthUserDTO();
        authUserDTO.setUsername(userDO.getUsername());
        authUserDTO.setPassword(userDO.getPassword());
        authUserDTO.setRoleNames(roleNameList);
        return authUserDTO;
    }
}
