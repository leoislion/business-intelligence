package com.isoftstone.bi.userserver.service.impl;

import com.isoftstone.bi.userserver.entity.BiUserRole;
import com.isoftstone.bi.userserver.mapper.BiUserRoleMapper;
import com.isoftstone.bi.userserver.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 0.0.1
 * @className: UserRoleServiceImpl
 * @author: Mr.Huang
 * @dsec: TODO
 */
@Service
public class UserRoleServiceImpl  implements UserRoleService{

    @Autowired
    BiUserRoleMapper biUserRoleMapper;

    /**
     * 添加userRoleRelation
     *
     * @param biUserRole
     * @return boolean
     */
    @Override
    public boolean addUserRole(BiUserRole biUserRole) {
        return biUserRoleMapper.addUserRole(biUserRole);
    }

    /**
     * 删除userRoleRelation
     *
     * @param biUserRole
     * @return boolean
     */
    @Override
    public boolean deleteByUserRoleId(BiUserRole biUserRole) {
        return biUserRoleMapper.deleteByUserRoleId(biUserRole);
    }

    /**
     * 删除所选userRoleRelation
     *
     * @param biUserRole
     * @return boolean
     * @author Mr.Huang
     */
    @Override
    public boolean deleteAllByUserRoleIds(BiUserRole biUserRole) {
        return biUserRoleMapper.deleteAllByUserRoleIds(biUserRole);
    }

    /**
     * 查询userRoleRelation
     *
     * @param biUserRole
     * @return Result<BiUserRole>
     */
    @Override
    public List<BiUserRole> queryUserRole(BiUserRole biUserRole) {
        return biUserRoleMapper.queryUserRole(biUserRole);
    }

    /**
     * 查询所有userRoleRelation
     *
     * @return Result<BiUserRole>
     */
    @Override
    public List<BiUserRole> queryUserRoleAll() {
        return biUserRoleMapper.queryUserRoleAll();
    }

    /**
     * 更新用户
     *
     * @param biUserRole
     * @return Result<int>
     */
    @Override
    public int updateUserRole(BiUserRole biUserRole) {
        return biUserRoleMapper.updateUserRole(biUserRole);
    }

    @Override
    public BiUserRole getByUserId(Long userId) {
        return biUserRoleMapper.getByUserId(userId);
    }
}
