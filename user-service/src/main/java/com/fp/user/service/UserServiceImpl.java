package com.fp.user.service;

import com.fp.user.api.IUserService;
import com.fp.user.api.domain.bo.UserBO;
import com.fp.user.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wcy
 */
@Component
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

}
