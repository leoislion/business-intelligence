package com.isoftstone.bi.userserver.service.impl;

import com.isoftstone.bi.userserver.entity.BiRole;
import com.isoftstone.bi.userserver.entity.BiUser;
import com.isoftstone.bi.userserver.mapper.BiRoleMapper;
import com.isoftstone.bi.userserver.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: RoleServiceImpl
 * @Author: Mr.Huang
 * @Date: 2019/2/25 13:53
 * @Version 0.0.1
 * @Dsec: TODO
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    BiRoleMapper biRoleMapper;

    /**
     * 添加角色
     *
     * @param biRole
     * @return boolean
     */
    @Override
    public boolean addRole(BiRole biRole) {
        int num = biRoleMapper.addRole(biRole);
        if(num != 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 删除角色
     * @param id
     * @return boolean
     */
    @Override
    public boolean deleteById(int id) {
        return biRoleMapper.deleteByRoleId(id);
    }

    /**
     * 批量删除
     * @param biRoleList
     * @return boolean
     * @author Mr.Huang
     */
    @Override
    public boolean deleteAll(List<BiRole> biRoleList) {
        List<Long> roleIdsList = new ArrayList<>();
        biRoleList.forEach(item->{roleIdsList.add(item.getRoleId());});
        return biRoleMapper.deleteAll(roleIdsList);
    }

    /**
     * 查询角色
     *
     * @param roleName
     * @return Result<BiRole>
     */
    @Override
    public List<BiRole> queryRole(String roleName) {
        List<BiRole> list = biRoleMapper.queryRole(roleName);
        return list;
    }

    /**
     * 查询多个角色
     *
     * @param biRole
     * @return List<BiRole>
     */
    @Override
    public List<BiRole> queryRoleIds(BiRole biRole) {
        return biRoleMapper.queryRoleIds(biRole);
    }

    /**
     * 查询所有角色
     * @return Result<BiRole>
     */
    @Override
    public List<BiRole> queryRoleAll() {
        return biRoleMapper.queryRoleAll();
    }

    /**
     * 更新角色
     *
     * @param record
     * @return Result<int>
     */
    @Override
    public int updateByPrimaryKeySelective(BiRole record) {
        return biRoleMapper.updateByPrimaryKeySelective(record);
    }
}
