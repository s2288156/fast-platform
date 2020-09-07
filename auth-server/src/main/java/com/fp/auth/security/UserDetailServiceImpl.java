//package com.fp.auth.security;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.fp.auth.dao.mapper.RoleMapper;
//import com.fp.auth.dao.mapper.UserMapper;
//import com.fp.auth.domain.dataobject.UserDO;
//import com.fp.tool.ex.BizException;
//import com.fp.tool.ex.ResultCodeEnum;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @author wcy
// */
//@Slf4j
//@Component
//public class UserDetailServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private RoleMapper roleMapper;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        log.info("loadUserByUsername = {}", username);
//        UserDO userDO = userMapper.selectOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getUsername, username));
//        if (userDO == null) {
//            throw new BizException(ResultCodeEnum.USER_LOGIN_ERROR);
//        }
//        List<String> roleNameList = roleMapper.listUserRoleName(userDO.getId());
//        List<SimpleGrantedAuthority> grantedAuthorityList = roleNameList
//                .stream()
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//        return new User(userDO.getUsername(), userDO.getPassword(), grantedAuthorityList);
//    }
//
//}
