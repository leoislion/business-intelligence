package com.isoftstone.bi.userserver.service;

import com.isoftstone.bi.userserver.entity.BiRole;

import java.util.List;

/**
 * @Desc: 角色
 * @Author: Mr.Huang
 * @Date: 2019/2/25 11:44
 * @Version 0.0.1
 */

public interface RoleService {

    /**
     * 添加角色
     * @param biRole
     * @return boolean
     */
    boolean addRole(BiRole biRole);

    /**
     * 删除角色
     * @param id
     * @return boolean
     */
    boolean deleteById(int id);

    /**
     * 批量删除
     * @author Mr.Huang
     * @param  biRoleList
     * @return boolean
     */
    boolean deleteAll(List<BiRole> biRoleList);

    /**
     * 查询角色
     * @param roleName
     * @return Result<BiRole>
     */
    List<BiRole> queryRole(String roleName);

   /**
     * 查询多个角色
     * @param biRole
     * @return List<BiRole>
     */
    List<BiRole> queryRoleIds(BiRole biRole);

    /**
     * 查询所有角色
     * @return Result<BiRole>
     */
    List<BiRole> queryRoleAll();

    /**
     * 更新角色
     * @param record
     * @return Result<int>
     */
    int updateByPrimaryKeySelective(BiRole record);

}
