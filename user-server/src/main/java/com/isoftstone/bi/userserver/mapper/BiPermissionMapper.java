package com.isoftstone.bi.userserver.mapper;

import com.isoftstone.bi.userserver.entity.BiPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Author: leo
 * @Date: 2019/2/28 15:54
 * @Version 0.0.1
 * @Desc 权限相关接口
 */
public interface BiPermissionMapper {
    /**
     *根据ID删除记录
     *@param  permissionId
     *@return  int
     *@author  leo
     *@date  2019/3/1
     */
    int deleteByPrimaryKey(Long permissionId);
    /**
     *新增记录
     *@param  record
     *@return  int
     *@author  leo
     *@date  2019/3/1
     */
    int insert(BiPermission record);
    /**
     *新增记录
     *@param  record
     *@return  int
     *@author  leo
     *@date  2019/3/1
     */
    int insertSelective(BiPermission record);
    /**
     *根据ID查找记录
     *@param  permissionId
     *@return  BiPermission
     *@author  leo
     *@date  2019/3/1
     */
    BiPermission selectByPrimaryKey(Long permissionId);
    /**
     *更新记录
     *@param  record
     *@return  int
     *@author  leo
     *@date  2019/3/1
     */
    int updateByPrimaryKeySelective(BiPermission record);
    /**
     *更新记录
     *@param  record
     *@return  int
     *@author  leo
     *@date  2019/3/1
     */
    int updateByPrimaryKey(BiPermission record);
    /**
     *根据roleId查询权限列表
     *@param  roleId
     *@return  List<BiPermission>
     *@author  leo
     *@date  2019/2/28
     */
    List<BiPermission> listByRoleId(@Param("roleId")Long roleId);
    /**
     *根据roleId删除权限
     *@param  roleId
     *@return  int
     *@author  leo
     *@date  2019/2/28
     */
    int deleteByRoleId(@Param("roleId")Long roleId);
    /**
     *批量插入
     *@param  list
     *@return
     *@author  leo
     *@date  2019/3/1
     */
    void insertList(@Param("list")List<BiPermission> list);
}
