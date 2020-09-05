package com.fp.auth.controller;

import com.fp.mybatis.base.PageInfo;
import com.fp.auth.domain.form.InsertRole;
import com.fp.auth.service.IRoleService;
import com.fp.tool.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@RequestMapping("/role")
@RestController
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @PostMapping("/insert")
    public RestResult<Integer> insert(InsertRole role) {
        return RestResult.success(roleService.insert(role));
    }

    @GetMapping("/list")
    public RestResult<?> list(PageInfo pageInfo) {

        return RestResult.success();
    }
}
