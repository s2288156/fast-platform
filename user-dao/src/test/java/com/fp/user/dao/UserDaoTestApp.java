package com.fp.user.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wcy
 */
@MapperScan("com.fp.user.dao.mapper")
@SpringBootApplication
public class UserDaoTestApp {
    public static void main(String[] args) {
        SpringApplication.run(UserDaoTestApp.class, args);
    }
}
