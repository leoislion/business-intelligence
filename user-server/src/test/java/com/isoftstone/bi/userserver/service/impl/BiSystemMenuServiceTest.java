package com.isoftstone.bi.userserver.service.impl;

import com.isoftstone.bi.userserver.service.BiPermissionService;
import com.isoftstone.bi.userserver.service.BiSystemMenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: leo
 * @Date: 2019/2/25 17:11
 * @Version 0.0.1
 * @Desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BiSystemMenuServiceTest {
    @Autowired
    BiSystemMenuService biSystemMenuService;
    @Autowired
    BiPermissionService biPermissionService;
    @Test
    public void menuTreeTest(){
        biSystemMenuService.getMenuTree();
    }
    @Test
    public void permisson(){
        biPermissionService.getPermissionByRoleId(4l);
    }
}
