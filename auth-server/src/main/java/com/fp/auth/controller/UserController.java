package com.fp.auth.controller;

import com.fp.auth.domain.bo.UserBO;
import com.fp.auth.domain.dataobject.RoleDO;
import com.fp.auth.domain.form.UserUpdate;
import com.fp.auth.domain.vo.UserVO;
import com.fp.auth.service.IRoleService;
import com.fp.auth.service.IUserService;
import com.fp.tool.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wcy
 */
@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    /**
     * @param id userId
     * @return 用户详情
     */
    @GetMapping("/{id}")
    public RestResult<UserVO> detail(@PathVariable String id) {
        UserBO userBO = userService.selectUserById(id);
        List<RoleDO> userRoles = roleService.getUserRoles(id);
        return RestResult.success(UserVO.assembleFor(userBO, userRoles));
    }

    @PutMapping("/detail/update")
    public RestResult<UserVO> update(UserUpdate userUpdate) {
        UserBO userBO = userService.update(userUpdate);
        return RestResult.success(UserVO.assembleFor(userBO));
    }
}
