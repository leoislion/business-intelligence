package com.isoftstone.bi.userserver.service.impl;

import com.isoftstone.bi.userserver.entity.BiUser;
import com.isoftstone.bi.userserver.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: leo
 * @Date: 2019/2/12 16:19
 * @Version 0.0.1
 * @Desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    UserService userService;
    @Test
    public void test(){
        BiUser biUser=new BiUser();
        biUser.setUserName("admin");
        biUser.setUserPassword("123456");
       // BiUser biUser1= userService.findUser(biUser);
       // System.out.println("id:"+biUser1.getUserId());
    }

}
