package com.isoftstone.bi.feignserver.Service.Impl;

import com.isoftstone.bi.feignserver.Service.UserService;
import org.springframework.stereotype.Component;


@Component
public class UserServiceHystrix implements UserService {

    @Override
    public String sayHelloFromClient() {
        return "sorry";
    }
}
