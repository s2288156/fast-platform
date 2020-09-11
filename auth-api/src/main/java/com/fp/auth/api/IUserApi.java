package com.fp.auth.api;

import com.fp.auth.doman.dto.AuthUserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wcy
 */
@FeignClient(name = "auth-server", path = "/auth")
public interface IUserApi {

    @GetMapping("/auth-user")
    AuthUserDTO selectAuthUser(String username);
}
