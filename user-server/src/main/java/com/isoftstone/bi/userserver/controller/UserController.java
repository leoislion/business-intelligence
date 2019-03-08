package com.isoftstone.bi.userserver.controller;

import com.isoftstone.bi.userserver.annotation.PassToken;
import com.isoftstone.bi.userserver.annotation.UserLoginToken;
import com.isoftstone.bi.userserver.entity.BiUser;
import com.isoftstone.bi.userserver.entity.BiUserRole;
import com.isoftstone.bi.userserver.service.*;
import com.isoftstone.bi.userserver.vo.ResponseVo;
import com.isoftstone.bi.userserver.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: leo
 * @Date: 2019/2/12 14:56
 * @Version 0.0.1
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    @Autowired
    BiPermissionService biPermissionService;
    @Autowired
    RedisHelper redisHelper;
    @Autowired
    UserRoleService userRoleService;
    @PostMapping(value = "/login")
    public ResponseVo login(@RequestBody UserVo  user){
        BiUser currentUser= userService.findUser(user);
        if(currentUser==null){
            return ResponseVo.appFail("用户名或密码错误");
        }else {
            UserVo userVo = new UserVo();
            String token = tokenService.getToken(currentUser);
            BiUserRole biUserRole=userRoleService.getByUserId(currentUser.getUserId());
            String permission=biPermissionService.getByRoleId(Long.parseLong(biUserRole.getRoleId()+""));
            String key=currentUser.getUserId()+currentUser.getUserName();
            redisHelper.valuePut(key,token);
            redisHelper.expirse(key,30, TimeUnit.MINUTES);
            token=key+":"+token;
            userVo.setUserId(currentUser.getUserId());
            userVo.setToken(token);
            userVo.setUserName(currentUser.getUserName());
            userVo.setPermission(permission);
            return ResponseVo.success(userVo);
        }
    }
    @UserLoginToken
    @GetMapping(value = "/getName/{name}")
    public ResponseVo getMessage(@PathVariable("name") String name){
        return ResponseVo.success(name);
    }
    @UserLoginToken
    @PostMapping(value = "/addUser")
    public ResponseVo addUser(@RequestBody BiUser  biUser){
        Logger.getLogger("UserController").info(biUser.toString());
        boolean flag = userService.addUser(biUser);
        if(flag){
            return ResponseVo.success("新增用户成功");
        }else{
            return ResponseVo.serviceFail("新增用户失败");
        }
    }
    @UserLoginToken
    @DeleteMapping(value = "/deleteByUserId/{id}")
    public ResponseVo deleteByUserId(@PathVariable("id")int userId){
        boolean flag = userService.deleteByUserId(userId);
        if(flag){
            return ResponseVo.success("删除成功");
        }else{
            return ResponseVo.serviceFail("删除失败");
        }
    }
    @UserLoginToken
    @PostMapping(value = "/deleteAllByUserIds")
    public ResponseVo deleteAllByUserIds(@RequestBody List<BiUser>  biUserList){
        biUserList.forEach(item->{System.out.println(item);});
        boolean flag = userService.deleteAllByUserIds(biUserList);
        if(flag){
            return ResponseVo.success("批量删除成功");
        }else{
            return ResponseVo.serviceFail("批量删除失败");
        }
    }
    @UserLoginToken
    @GetMapping(value = "/queryUser/{userName}")
    public ResponseVo queryUser(@PathVariable("userName") String userName) {
        Logger.getLogger("UserController").info("查询用户名："+userName);
        List<BiUser> userInfo = userService.queryUser(userName);
        if (userInfo != null) {
            return ResponseVo.success(userInfo);
        } else {
            return ResponseVo.serviceFail("该用户不存在");
        }
    }
    @UserLoginToken
    @GetMapping(value = "/queryUserAll")
    public List<BiUser> queryUserAll() {
        return userService.queryUserAll();
    }
    @UserLoginToken
    @PutMapping(value = "/update")
    public ResponseVo update(@RequestBody BiUser biUser){
        int flag = userService.updateUser(biUser);
        if(flag != 0) {
            return ResponseVo.success("更新成功");
        }
        return ResponseVo.serviceFail("更新失败");
    }
    /**
     *退出
     *@param  userVo
     *@return  ResponseVo
     *@author  leo
     *@date  2019/3/6
     */
    @UserLoginToken
    @PostMapping(value = "/logout")
    public ResponseVo logout(@RequestBody UserVo userVo){
        String key=userVo.getUserId()+userVo.getUserName();
        redisHelper.remove(key);
        return ResponseVo.success("退出成功");
    }
}
