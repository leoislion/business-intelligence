package com.isoftstone.bi.userserver.service.impl;

import com.isoftstone.bi.userserver.entity.BiPermission;
import com.isoftstone.bi.userserver.mapper.BiPermissionMapper;
import com.isoftstone.bi.userserver.service.BiPermissionService;
import com.isoftstone.bi.userserver.service.BiSystemMenuService;
import com.isoftstone.bi.userserver.vo.MenuTree;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: leo
 * @Date: 2019/2/28 15:57
 * @Version 0.0.1
 * @Desc
 */
@Slf4j
@Service
public class BiPermissionServiceImpl implements BiPermissionService {
    @Autowired
    BiSystemMenuService biSystemMenuService;
    @Autowired
    BiPermissionMapper biPermissionMapper;
    @Override
    public List<MenuTree> getPermissionByRoleId(Long roleId) {
        List<MenuTree> menuTree = biSystemMenuService.getMenuTree();
        List<BiPermission> biPermissions=biPermissionMapper.listByRoleId(roleId);
        menuTree=handlePermissions(menuTree,biPermissions);
        return menuTree;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateOrInsertPermission(MenuTree menuTree) {
        //首先删除所有权限
        biPermissionMapper.deleteByRoleId(menuTree.getRoleId());
        List<MenuTree> menuTreeList=menuTree.getChildren();
        List<BiPermission>  biPermissionList= menuTreeList.stream().map(menuTree1 -> {
            BiPermission biPermission=new BiPermission();
            biPermission.setPermissionName(menuTree1.getTitle());
            biPermission.setPermissionUrl(menuTree1.getMenuEnName());
            biPermission.setRoleId(menuTree.getRoleId());
            return biPermission;
        }).collect(Collectors.toList());
        try {
            biPermissionMapper.insertList(biPermissionList);
            return true;
        }catch (Exception e){
            log.debug("业务异常");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String getByRoleId(Long roleId) {
        List<BiPermission> biPermissions=biPermissionMapper.listByRoleId(roleId);
        StringBuilder stringBuilder=new StringBuilder();
        for(BiPermission biPermission:biPermissions){
           stringBuilder= stringBuilder.append(biPermission.getPermissionUrl()).append(",");

        }
        log.debug("权限："+stringBuilder.toString());
        return stringBuilder.toString();
    }

    private List<MenuTree> handlePermissions(List<MenuTree> menuTrees,List<BiPermission> biPermissions){
        menuTrees= menuTrees.stream().map(menuTree -> {
            biPermissions.forEach(biPermission -> {
                if(biPermission.getPermissionName().equals(menuTree.getTitle())){
                    if(menuTree.getChildren().size()!=0) {
                        menuTree.setChecked(false);
                    }else {
                        menuTree.setChecked(true);
                    }
                }
            });
            List<MenuTree> children=menuTree.getChildren();
            if(children.size()!=0){
                children=handlePermissions(children,biPermissions);
            }
            menuTree.setChildren(children);
            return menuTree;
        }).collect(Collectors.toList());
        return menuTrees;
    };
}
