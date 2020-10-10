package com.fp.auth.service.impl;

import com.fp.auth.constant.AuthConstant;
import com.fp.auth.constant.MessageConstant;
import com.fp.auth.domain.SecurityUser;
import com.fp.auth.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author wcy
 */
@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private HttpServletRequest request;

    private static UserDto userDto1;
    private static UserDto userDto2;

    static {
        userDto1 = new UserDto();
        userDto2 = new UserDto();
        userDto1.setId(1L);
        userDto1.setClientId("admin-app");
        userDto1.setUsername("admin");
        userDto1.setPassword("$10$cZPG3faFFTTu.S1SucsIfuosvOR257lljuorKc0ptVBDs5oDWxlAO");
        userDto1.setRoles(Arrays.asList("A", "B", "C"));

        userDto2.setId(2L);
        userDto2.setClientId("portal-app");
        userDto2.setUsername("portal");
        userDto2.setPassword("$10$cZPG3faFFTTu.S1SucsIfuosvOR257lljuorKc0ptVBDs5oDWxlAO");
        userDto2.setRoles(Arrays.asList("A1", "B1", "C1"));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        String clientId = request.getParameter("client_id");
        UserDto userDto;
        if(AuthConstant.ADMIN_CLIENT_ID.equals(clientId)){
            userDto = userDto1;
        }else{
            userDto = userDto2;
        }
        if (userDto==null) {
            throw new UsernameNotFoundException(MessageConstant.USERNAME_PASSWORD_ERROR);
        }
        userDto.setClientId(clientId);
        SecurityUser securityUser = new SecurityUser(userDto);
        if (!securityUser.isEnabled()) {
            throw new DisabledException(MessageConstant.ACCOUNT_DISABLED);
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException(MessageConstant.ACCOUNT_LOCKED);
        } else if (!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException(MessageConstant.ACCOUNT_EXPIRED);
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(MessageConstant.CREDENTIALS_EXPIRED);
        }
        return securityUser;
    }
}
