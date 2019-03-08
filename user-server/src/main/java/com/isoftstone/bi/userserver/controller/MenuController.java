package com.isoftstone.bi.userserver.controller;

import com.isoftstone.bi.userserver.annotation.UserLoginToken;
import com.isoftstone.bi.userserver.service.BiSystemMenuService;
import com.isoftstone.bi.userserver.vo.MenuVo;
import com.isoftstone.bi.userserver.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: leo
 * @Date: 2019/2/26 17:13
 * @Version 0.0.1
 * @Desc
 */
@Slf4j
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    BiSystemMenuService biSystemMenuService;
    /**
     *获取菜单树
     *@param
     *@return  ResponseVo
     *@author  leo
     *@date  2019/2/26
     */
    @UserLoginToken
    @GetMapping(value = "/getMenuTree")
    public ResponseVo getMenuTree(){
        return ResponseVo.success(biSystemMenuService.getMenuTree());
    }
    /**
     *添加菜单
     *@param  menuVo
     *@return  ResponseVo
     *@author  leo
     *@date  2019/2/27
     */
    @UserLoginToken
    @PostMapping(value = "/addMenu")
    public ResponseVo addMenu(@RequestBody MenuVo menuVo){
        return biSystemMenuService.insertMenu(menuVo);
    }
    @UserLoginToken
    @DeleteMapping(value = "/deleteMenu/{menuName}")
    public ResponseVo deleteMenu(@PathVariable("menuName")String menuName){
       if(StringUtils.isEmpty(menuName)){
           return ResponseVo.serviceFail("参数错误");
       }else {
           MenuVo menuVo=new MenuVo();
           menuVo.setMenuName(menuName);
           biSystemMenuService.deleteMenu(menuVo);
           return ResponseVo.success("删除成功");
       }

    }

}
