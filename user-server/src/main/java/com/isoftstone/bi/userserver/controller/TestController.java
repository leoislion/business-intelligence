package com.isoftstone.bi.userserver.controller;

import com.isoftstone.bi.userserver.annotation.UserLoginToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class TestController {
    @Value("${server.port}")
    String port;

    @RequestMapping("/test")
    public String test(){
        return "123:"+port;
    }
}
