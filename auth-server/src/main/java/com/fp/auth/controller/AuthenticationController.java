package com.fp.auth.controller;

import com.fp.auth.domain.dataobject.UserDO;
import com.fp.auth.domain.dto.UserDTO;
import com.fp.auth.domain.form.AddRoles;
import com.fp.auth.domain.form.Register;
import com.fp.auth.domain.vo.UserVO;
import com.fp.auth.service.IAuthorizationService;
import com.fp.auth.service.IUserService;
import com.fp.tool.RestResult;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wcy
 */
@RestController
public class AuthenticationController {

    @Autowired
    private IAuthorizationService authorizationService;

    @Autowired
    private IUserService userService;

    @Autowired
    private KeyPair keyPair;

    @GetMapping("/rsa/public_key")
    public RestResult<?> getPublicKey() {
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return RestResult.success(new JWKSet(key).toJSONObject());
    }

    @PostMapping("/login")
    public RestResult<?> login() {
        return RestResult.success();
    }

    /**
     * 用户注册
     *
     * @param register 用户信息
     * @return 注册结果
     */
    @PostMapping("/register")
    public RestResult<?> register(@Validated Register register) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(register, userDTO);

        userService.register(userDTO);
        return RestResult.success();
    }

    /**
     * 给用户添加ROLE
     *
     * @return result
     */
    @PostMapping("/add/roles")
    public RestResult<?> addRolesToUser(@Validated AddRoles addRoles) {
        int number = userService.addRoles(addRoles.getRoleIds(), addRoles.getUserId());
        return RestResult.success(number);
    }

    //    @PreAuthorize("hasAnyAuthority('admin')")
    @GetMapping("/all")
    public RestResult<List<UserVO>> all() {
        List<UserDO> userDOList = authorizationService.allUser();
        List<UserVO> userVOList = userDOList.stream()
                .map(userDO -> {
                    UserVO userVO = new UserVO();
                    BeanUtils.copyProperties(userDO, userVO);
                    return userVO;
                })
                .collect(Collectors.toList());
        return RestResult.success(userVOList);
    }

}
