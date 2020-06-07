package com.bluto.security.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * ${file_name}
 *
 * @author bluto
 * @Description: ${todo}
 * @date 2020/6/7 18:55
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.bluto.security.springmvc"
        )
public class WebConfig implements WebMvcConfigurer {
    //不用独立定义拦截器，springsecurity已经定义好了

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //redirect:/login 是Spring Security提供的登录页面
        registry.addViewController("/").setViewName("redirect:/login");
    }

    //视图解析器
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
