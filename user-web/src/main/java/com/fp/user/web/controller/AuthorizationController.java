package com.fp.user.web.controller;

import com.fp.tool.RestResult;
import com.fp.user.dao.domain.dataobject.UserDO;
import com.fp.user.dao.domain.dto.UserDTO;
import com.fp.user.service.IAuthorizationService;
import com.fp.user.service.IUserService;
import com.fp.user.web.domain.form.Register;
import com.fp.user.web.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public RestResult<?> register(Register register) {
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
    @PostMapping
    public RestResult<?> addRolesToUser() {

        return RestResult.success();
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
