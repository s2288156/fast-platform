package com.fp.user.web;

import com.fp.user.api.IUserService;
import com.fp.user.web.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@Slf4j
@RequestMapping
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserVO> findUserName(@PathVariable String id) {
        String userName = userService.getUserName(id);
        UserVO userVO = new UserVO();
        userVO.setUsername(userName);
        return ResponseEntity.ok(userVO);
    }

}
