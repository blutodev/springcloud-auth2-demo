package com.bluto.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * OAuthServer
 *
 * @author bluto
 * @Description: 授权服务启动类
 * @date 2020/6/7 9:29
 */
@SpringBootApplication
@ComponentScan
public class OAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuthServerApplication.class, args);
    }
}
