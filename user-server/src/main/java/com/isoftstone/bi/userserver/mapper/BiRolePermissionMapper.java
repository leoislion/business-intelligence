package com.isoftstone.bi.userserver.mapper;

import com.isoftstone.bi.userserver.entity.BiRolePermission;

public interface BiRolePermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BiRolePermission record);

    int insertSelective(BiRolePermission record);

    BiRolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BiRolePermission record);

    int updateByPrimaryKey(BiRolePermission record);
}