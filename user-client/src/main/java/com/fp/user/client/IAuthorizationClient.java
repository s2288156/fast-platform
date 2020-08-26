package com.fp.user.client;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author wcy
 */
@FeignClient(name = "user", path = "/user")
public interface IAuthorizationClient {


}
