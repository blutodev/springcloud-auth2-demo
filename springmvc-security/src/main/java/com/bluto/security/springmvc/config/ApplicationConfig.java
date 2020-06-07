package com.bluto.security.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * ${file_name}
 *
 * @author bluto
 * @Description: ${todo}
 * @date 2020/6/7 18:51
 */
@Configuration
@ComponentScan(basePackages = "com.bluto.security.springmvc")
 //       excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class ApplicationConfig {

    //在此配置其他bean，数据库连接池，事务管理器，业务bean等
}
