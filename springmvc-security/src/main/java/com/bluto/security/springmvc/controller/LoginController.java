package com.bluto.security.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${file_name}
 *
 * @author bluto
 * @Description: ${todo}
 * @date 2020/6/7 19:25
 */
@RestController
public class LoginController {
    @RequestMapping(value = "/login-success", method = RequestMethod.POST, produces = {"text/plain;charset=UTF-8"})
    public String loginSuccess(){
        return "登录成功";
    }

    @RequestMapping(value = "/r/r1" , produces = {"text/plain;charset=UTF-8"})
    public String r1(){
        return "访问资源1";
    }

    @RequestMapping(value = "/r/r2" , produces = {"text/plain;charset=UTF-8"})
    public String r2(){
        return "访问资源2";
    }
}
