package com.fp.user.web.controller;

import com.fp.tool.RestResult;
import com.fp.user.dao.domain.dataobject.UserDO;
import com.fp.user.dao.domain.dto.UserDTO;
import com.fp.user.service.IAuthorizationService;
import com.fp.user.service.IUserService;
import com.fp.user.web.domain.form.AddRoles;
import com.fp.user.web.domain.form.Register;
import com.fp.user.web.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户账户登录、授权、退出等操作
 *
 * @author wcy
 */
@Slf4j
@RestController
public class AuthorizationController {

    @Autowired
    private IAuthorizationService authorizationService;

    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 用户注册
     *
     * @param register 用户信息
     * @return 注册结果
     */
    @PostMapping("/register")
    public RestResult<?> register(@Validated Register register) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(register, userDTO);
        userDTO.setPassword(passwordEncoder.encode(register.getPassword()));
        userService.register(userDTO);
        return RestResult.success();
    }

    /**
     * 给用户添加ROLE
     *
     * @return result
     */
    @PostMapping("/add/roles")
    public RestResult<?> addRolesToUser(@Validated AddRoles addRoles) {
        int number = userService.addRoles(addRoles.getRoleIds(), addRoles.getUserId());
        return RestResult.success(number);
    }

    @PreAuthorize("hasAnyAuthority('admin')")
    @GetMapping("/all")
    public RestResult<List<UserVO>> all() {
        List<UserDO> userDOList = authorizationService.allUser();
        List<UserVO> userVOList = userDOList.stream()
                .map(userDO -> {
                    UserVO userVO = new UserVO();
                    BeanUtils.copyProperties(userDO, userVO);
                    return userVO;
                })
                .collect(Collectors.toList());
        return RestResult.success(userVOList);
    }

}
