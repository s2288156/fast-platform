package com.fp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wcy
 */
@MapperScan("com.fp.mall.dao.mapper")
@EnableTransactionManagement
@EnableDiscoveryClient
@SpringBootApplication
public class MallApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }
}
