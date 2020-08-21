package com.fp.user.web.client;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fp.tool.ex.BizException;
import com.fp.tool.ex.ResultCodeEnum;
import com.fp.user.dao.domain.dataobject.UserDO;
import com.fp.user.dao.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author wcy
 */
@Slf4j
@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername = {}", username);
        UserDO userDO = userMapper.selectOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getUsername, username));
        if (userDO == null) {
            throw new BizException(ResultCodeEnum.USER_LOGIN_ERROR);
        }
        return new User(userDO.getUsername(), userDO.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
