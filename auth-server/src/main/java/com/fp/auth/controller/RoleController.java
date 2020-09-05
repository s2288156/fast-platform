package com.fp.auth.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fp.auth.domain.dataobject.RoleDO;
import com.fp.auth.domain.vo.RoleVO;
import com.fp.mybatis.base.PageInfo;
import com.fp.auth.domain.form.InsertRole;
import com.fp.auth.service.IRoleService;
import com.fp.tool.RestResult;
import com.fp.mybatis.base.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
    public RestResult<PageResult<RoleVO>> list(PageInfo pageInfo) {
        Page<RoleDO> roleDOPage = roleService.pageRoles(pageInfo);
        PageResult<RoleVO> pageResult = PageResult.createFor(roleDOPage);
        List<RoleVO> roleVOList = roleDOPage.getRecords().stream()
                .map(roleDO -> {
                    RoleVO roleVO = new RoleVO();
                    BeanUtils.copyProperties(roleDO, roleVO);
                    return roleVO;
                })
                .collect(Collectors.toList());
        pageResult.setRecords(roleVOList);

        return RestResult.success(pageResult);
    }
}
