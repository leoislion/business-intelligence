package com.isoftstone.bi.userserver.controller;
import com.isoftstone.bi.userserver.annotation.UserLoginToken;
import com.isoftstone.bi.userserver.entity.BiUserRole;
import com.isoftstone.bi.userserver.service.UserRoleService;
import com.isoftstone.bi.userserver.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * @version 0.0.1
 * @className: UserRoleController
 * @author: Mr.Huang
 * @date: 2019/3/1 11:10
 * @dsec: TODO
 */
@RestController
@RequestMapping("/userRole")
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;
    @UserLoginToken
    @PostMapping(value = "/addUserRole")
    public ResponseVo addUserRole(@RequestBody BiUserRole biUserRole){
        Logger.getLogger("UserController").info(biUserRole.toString());
        boolean flag = userRoleService.addUserRole(biUserRole);
        if(flag){
            return ResponseVo.success("成功");
        }else{
            return ResponseVo.serviceFail("失败");
        }
    }
    @UserLoginToken
    @PostMapping(value = "/deleteByUserRoleId")
    public ResponseVo deleteByUserRoleId(@RequestBody BiUserRole biUserRole){
        Logger.getLogger("UserController").info(biUserRole.toString());
        boolean flag = userRoleService.deleteByUserRoleId(biUserRole);
        if(flag){
            return ResponseVo.success("成功");
        }else{
            return ResponseVo.serviceFail("失败");
        }
    }
    @UserLoginToken
    @PostMapping(value = "/deleteAllByUserRoleIds")
    public ResponseVo deleteAllByUserRoleIds(@RequestBody BiUserRole biUserRole){
       Logger.getLogger("UserController").info(biUserRole.toString());
        boolean flag = userRoleService.deleteAllByUserRoleIds(biUserRole);
        if(flag){
            return ResponseVo.success("成功");
        }else{
            return ResponseVo.serviceFail("失败");
        }
    }
    @UserLoginToken
    @PostMapping(value = "/updateUserRole")
    public ResponseVo updateUserRole(@RequestBody BiUserRole biUserRole){
        int flag = userRoleService.updateUserRole(biUserRole);
        if(flag != 0){
            return ResponseVo.success("成功");
        }else{
            return ResponseVo.serviceFail("失败");
        }
    }
    @UserLoginToken
    @PostMapping(value = "/queryUserRole")
    public ResponseVo queryUserRole(@RequestBody BiUserRole biUserRole) {
        List<BiUserRole> info = userRoleService.queryUserRole(biUserRole);
        if (info != null) {
            return ResponseVo.success(info);
        } else {
            return ResponseVo.serviceFail("查询异常");
        }
    }
}
