package com.fp.user.service.security;

import com.fp.tool.ex.BizException;
import com.fp.tool.ex.ResultCodeEnum;
import com.fp.user.dao.domain.dataobject.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author wcy
 */
@Component
public class UserDetailServiceImpl implements UserDetailsService {



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<UserDO> optionalUser = userRepository.findByUsername(username);
//        UserDO userDO = optionalUser.orElseThrow(() -> new BizException(ResultCodeEnum.USER_LOGIN_ERROR));
//        User admin = new User(userDO.getUsername(), userDO.getPassword(),
//                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//        return admin;
        // TODO: 2020/8/20 补充dao逻辑
        return null;
    }
}
