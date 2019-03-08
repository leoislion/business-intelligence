package com.isoftstone.bi.userserver.service;

import com.isoftstone.bi.userserver.entity.BiPermission;
import com.isoftstone.bi.userserver.vo.MenuTree;

import java.util.List;

/**
 * @Author: leo
 * @Date: 2019/2/28 15:54
 * @Version 0.0.1
 * @Desc 权限相关接口
 */
public interface BiPermissionService {
    /**
     *根据角色Id查询权限列表
     *@param  roleId
     *@return  List<BiPermission>
     *@author  leo
     *@date  2019/2/28
     */
    List<MenuTree> getPermissionByRoleId(Long roleId);
    /**
     *更新权限
     *@param  menuTree
     *@return  boolean
     *@author  leo
     *@date  2019/2/28
     */
    boolean updateOrInsertPermission( MenuTree menuTree);
    /**
     *根据roleId查询
     *@param  roleId
     *@return  String
     *@author  leo
     *@date  2019/3/1
     */
    String getByRoleId(Long roleId);
}
