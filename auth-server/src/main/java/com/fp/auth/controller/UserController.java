package com.fp.auth.controller;

import com.fp.auth.domain.vo.UserVO;
import com.fp.tool.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {

    /**
     * @param id userId
     * @return 用户详情
     */
    @GetMapping("/{id}")
    public RestResult<UserVO> detail(@PathVariable String id) {

        return RestResult.success();
    }
}
