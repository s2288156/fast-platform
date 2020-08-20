package com.fp.user.dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author wcy
 */
@EnableJpaRepositories
@SpringBootApplication
public class UserDaoTestApp {
    public static void main(String[] args) {
        SpringApplication.run(UserDaoTestApp.class, args);
    }
}
