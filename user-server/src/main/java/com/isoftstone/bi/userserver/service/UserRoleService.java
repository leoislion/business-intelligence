package com.isoftstone.bi.userserver.service;

import com.isoftstone.bi.userserver.entity.BiUserRole;

import java.util.List;

/**
 * @version 0.0.1
 * @className: UserRoleService
 * @author: Mr.Huang
 * @dsec: TODO
 */
public interface UserRoleService {

    /**
     * 添加userRoleRelation
     * @param biUserRole
     * @return boolean
     */
    boolean addUserRole(BiUserRole biUserRole);

    /**
     * 删除userRoleRelation
     * @param biUserRole
     * @return boolean
     */
    boolean deleteByUserRoleId(BiUserRole biUserRole);

    /**
     * 删除所选userRoleRelation
     * @author Mr.Huang
     * @param  biUserRole
     * @return boolean
     */
    boolean deleteAllByUserRoleIds(BiUserRole biUserRole);

    /**
     * 查询userRoleRelation
     * @param biUserRole
     * @return Result<BiUserRole>
     */
    List<BiUserRole> queryUserRole(BiUserRole biUserRole);

    /**
     * 查询所有userRoleRelation
     * @return Result<BiUserRole>
     */
    List<BiUserRole> queryUserRoleAll();

    /**
     * 更新用户
     * @param biUserRole
     * @return Result<int>
     */
    int updateUserRole(BiUserRole biUserRole);
    BiUserRole getByUserId(Long userId);

}
