package com.isoftstone.bi.feignserver.controller;

import com.isoftstone.bi.feignserver.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: leo
 * @Date: 2019/2/12 15:49
 * @Version 0.0.1
 * @Desc 用来跳过token的注解
 */
@RestController
@RequestMapping("/feign")
public class FeignController {
    @Autowired
    UserService userService;
    @GetMapping("/test")
    public String test(){
        return userService.sayHelloFromClient();
    }
}
