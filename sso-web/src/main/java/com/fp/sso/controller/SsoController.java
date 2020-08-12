package com.fp.sso.controller;

import com.fp.user.client.IAuthorizationClient;
import com.fp.user.client.domain.dto.LoginDTO;
import com.fp.user.client.domain.dto.LoginResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@RestController
public class SsoController {

    @Autowired
    private IAuthorizationClient authorizationClient;

    @PostMapping("/login")
    LoginResultDTO login(LoginDTO loginDTO) {
        return authorizationClient.login(loginDTO);
    }

}
