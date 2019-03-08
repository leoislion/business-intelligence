package com.isoftstone.bi.userserver.controller;

import com.isoftstone.bi.userserver.annotation.UserLoginToken;
import com.isoftstone.bi.userserver.entity.BiRole;
import com.isoftstone.bi.userserver.entity.BiUser;
import com.isoftstone.bi.userserver.service.RoleService;
import com.isoftstone.bi.userserver.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * @ClassName: RoleController
 * @Author: Mr.Huang
 * @Date: 2019/2/25 11:40
 * @Version 0.0.1
 * @Dsec: TODO
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;
    @UserLoginToken
    @PostMapping(value = "/addRole")
    public ResponseVo addRole(@RequestBody BiRole biRole){
        Logger.getLogger("RoleController").info(biRole.toString());
        boolean flag = roleService.addRole(biRole);
        if(flag){
            return ResponseVo.success("新增角色成功");
        }else{
            return ResponseVo.serviceFail("新增角色失败");
        }
    }
    @UserLoginToken
    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseVo deleteById(@PathVariable("id")int id){
        System.out.println(id);
        boolean flag = roleService.deleteById(id);
        if(flag){
            return ResponseVo.success("删除成功");
        }else{
            return ResponseVo.serviceFail("删除失败");
        }
    }
    @UserLoginToken
    @PostMapping(value = "/deleteAll")
    public ResponseVo deleteAll(@RequestBody List<BiRole>  biRoleList){
        boolean flag = roleService.deleteAll(biRoleList);
        if(flag){
            return ResponseVo.success("批量删除成功");
        }else{
            return ResponseVo.serviceFail("批量删除失败");
        }
    }
    @UserLoginToken
    @GetMapping(value = "/queryRole/{roleName}")
    public ResponseVo queryRole(@PathVariable("roleName") String roleName) {
        Logger.getLogger("RoleController").info("查询角色名称：" + roleName);
        List<BiRole> roleInfo = roleService.queryRole(roleName);
        if (roleInfo != null) {
            return ResponseVo.success(roleInfo);
        } else {
            return ResponseVo.serviceFail("该角色不存在");
        }
    }
    @UserLoginToken
    @PostMapping(value = "/queryRoleIds")
    public ResponseVo queryRoleIds(@RequestBody BiRole biRole) {
        Logger.getLogger("RoleController").info("queryRoleIds===>"+biRole.toString());
        System.out.println(biRole);
        List<BiRole> roleInfo = roleService.queryRoleIds(biRole);
        if (roleInfo != null) {
            return ResponseVo.success(roleInfo);
        } else {
            return ResponseVo.serviceFail("异常");
        }
    }
    @UserLoginToken
    @GetMapping(value = "/queryRoleAll")
    public List<BiRole> queryRoleAll() {
        return roleService.queryRoleAll();
    }
    @UserLoginToken
    @PutMapping(value = "/update")
    public ResponseVo update(@RequestBody BiRole biRole) {
        int flag = roleService.updateByPrimaryKeySelective(biRole);
        if (flag != 0) {
            return ResponseVo.success("更新成功");
        }
        return ResponseVo.serviceFail("更新失败");

    }
}
