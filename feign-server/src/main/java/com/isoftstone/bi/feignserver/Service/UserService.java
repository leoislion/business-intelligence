package com.isoftstone.bi.feignserver.Service;

import com.isoftstone.bi.feignserver.Service.Impl.UserServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @Author: leo
 * @Date: 2019/2/12 14:56
 * @Version 0.0.1
 * @Dsec: 熔断实例
 */
@FeignClient(value = "user-service",fallback = UserServiceHystrix.class)
public interface UserService {

    @RequestMapping(value = "user/test")
    String sayHelloFromClient();
}
