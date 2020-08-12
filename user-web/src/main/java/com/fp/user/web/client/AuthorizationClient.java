package com.fp.user.web.client;

import com.fp.user.api.IAuthorizationService;
import com.fp.user.api.domain.bo.UserBO;
import com.fp.user.api.domain.query.UserQuery;
import com.fp.user.client.IAuthorizationClient;
import com.fp.user.client.domain.dto.LoginDTO;
import com.fp.user.client.domain.dto.LoginResultDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@RestController
public class AuthorizationClient implements IAuthorizationClient {

    @Autowired
    private IAuthorizationService authorizationService;

    @PostMapping("/login")
    @Override
    public LoginResultDTO login(LoginDTO loginDTO) {
        UserQuery userQuery = new UserQuery();
        BeanUtils.copyProperties(loginDTO, userQuery);

        UserBO userBO = authorizationService.login(userQuery);
        LoginResultDTO loginResultDTO = new LoginResultDTO();
        BeanUtils.copyProperties(userBO, loginResultDTO);
        return loginResultDTO;
    }
}
