package com.fp.foo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.fp.foo")
public class DemoFooApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoFooApplication.class, args);
    }

}
