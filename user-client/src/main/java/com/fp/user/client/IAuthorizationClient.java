package com.fp.user.client;

import com.fp.user.client.domain.dto.LoginDTO;
import com.fp.user.client.domain.dto.LoginResultDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wcy
 */
@FeignClient(name = "${spring.application.name}")
public interface IAuthorizationClient {

    /**
     * 用户登录
     *
     * @param loginDTO request
     * @return response
     */
    @GetMapping("/login")
    LoginResultDTO login(LoginDTO loginDTO);
}
