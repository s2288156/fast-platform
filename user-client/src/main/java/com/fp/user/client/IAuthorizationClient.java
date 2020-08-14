package com.fp.user.client;

import com.fp.tool.RestResult;
import com.fp.user.client.domain.dto.LoginDTO;
import com.fp.user.client.domain.dto.LoginResultDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wcy
 */
@FeignClient(name = "user", path = "/user")
public interface IAuthorizationClient {

    /**
     * 用户登录
     *
     * @param loginDTO request
     * @return response
     */
    @PostMapping("/login")
    RestResult<LoginResultDTO> login(@RequestBody LoginDTO loginDTO);
}
