package com.fp.user.service;

import com.fp.tool.ex.BizException;
import com.fp.tool.ex.ResultCodeEnum;
import com.fp.user.dao.dataobject.UserDO;
import com.fp.user.dao.repository.UserRepository;
import com.fp.user.service.domain.CustomUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
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

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDO> optionalUser = userRepository.findByUsername(username);
        UserDO userDO = optionalUser.orElseThrow(() -> new BizException(ResultCodeEnum.USER_LOGIN_ERROR));
        CustomUserDetail customUserDetail = new CustomUserDetail();
        customUserDetail.setPassword(userDO.getPassword());
        customUserDetail.setUsername(userDO.getUsername());
        customUserDetail.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return customUserDetail;
    }
}
