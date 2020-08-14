package com.fp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@RestController
public class TestController {

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/hello")
    public String login() {
        return "hello";
    }
}
