package com.fp.user.service.impl;

import com.fp.user.service.IUserService;
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
