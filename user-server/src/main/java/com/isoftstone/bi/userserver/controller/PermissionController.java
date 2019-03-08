package com.isoftstone.bi.userserver.controller;

import com.isoftstone.bi.userserver.annotation.UserLoginToken;
import com.isoftstone.bi.userserver.service.BiPermissionService;
import com.isoftstone.bi.userserver.vo.MenuTree;
import com.isoftstone.bi.userserver.vo.MenuVo;
import com.isoftstone.bi.userserver.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: leo
 * @Date: 2019/2/28 16:37
 * @Version 0.0.1
 * @Desc 权限分配
 */
@Slf4j
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    BiPermissionService biPermissionService;
    /**
     *根据Id查询权限
     *@param  roleId
     *@return  ResponseVo
     *@author  leo
     *@date  2019/2/28
     */
    @UserLoginToken
    @GetMapping(value = "/getPermission/{roleId}")
    public ResponseVo getPermission(@PathVariable("roleId")Long roleId){
        return ResponseVo.success(biPermissionService.getPermissionByRoleId(roleId));
    }
    /**
     *更新权限
     *@param  menuTree
     *@return  ResponseVo
     *@author  leo
     *@date  2019/2/28
     */
    @UserLoginToken
    @PostMapping(value = "updatePermission")
    public ResponseVo updatePermission(@RequestBody MenuTree menuTree){
        biPermissionService.updateOrInsertPermission(menuTree);
        System.out.println();
        return null;
    }
}
