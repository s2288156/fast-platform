package com.fp.user.web.controller;

import com.fp.tool.RestResult;
import com.fp.user.web.domain.form.Register;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户账户登录、授权、退出等操作g
 * @author wcy
 */
@Slf4j
@RestController
public class AuthorizationController {

    @PostMapping("/register")
    public RestResult<?> register(Register register) {

        return RestResult.success();
    }
}
