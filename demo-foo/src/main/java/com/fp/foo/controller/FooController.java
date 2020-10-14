package com.fp.foo.controller;

import com.fp.tool.domain.UserDto;
import com.fp.tool.util.JsonUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wcy
 */
@RestController
public class FooController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        return "hello world: " + request.getHeader("user");
    }

    public static void main(String[] args) {
        String json = "{\"user_name\":\"admin\",\"scope\":[\"all\"],\"id\":1,\"exp\":1602728915,\"authorities\":[\"A\",\"B\",\"C\"],\"jti\":\"0997b7ae-c3c7-4950-98b1-058728b60676\",\"client_id\":\"admin-app\"}";
        System.out.println(JsonUtils.fromJson(json, UserDto.class));
    }
}
