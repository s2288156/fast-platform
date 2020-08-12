package com.fp.user.web.controller;

import com.fp.tool.RestResult;
import com.fp.user.api.IAuthorizationService;
import com.fp.user.api.domain.dto.UserDTO;
import com.fp.user.web.domain.form.Register;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
        authorizationService.register(userDTO);
        return RestResult.success();
    }
    
}
