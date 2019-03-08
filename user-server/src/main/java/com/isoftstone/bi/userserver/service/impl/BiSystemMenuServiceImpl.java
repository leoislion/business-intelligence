package com.isoftstone.bi.userserver.service.impl;

import com.isoftstone.bi.userserver.entity.BiMenu;
import com.isoftstone.bi.userserver.mapper.BiMenuListMapper;
import com.isoftstone.bi.userserver.service.BiSystemMenuService;
import com.isoftstone.bi.userserver.vo.MenuTree;
import com.isoftstone.bi.userserver.vo.MenuVo;
import com.isoftstone.bi.userserver.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: leo
 * @Date: 2019/2/25 16:49
 * @Version 0.0.1
 * @Desc
 */
@Slf4j
@Service
public class BiSystemMenuServiceImpl implements BiSystemMenuService {
    @Autowired
    BiMenuListMapper biMenuListMapper;
    @Override
    public List<MenuTree> getMenuTree() {
        List<BiMenu> biMenuList=biMenuListMapper.list();
        List<BiMenu> parents=biMenuList.stream().filter(biMenu ->
                biMenu.getParentId()==0).collect(Collectors.toList());
        List<MenuTree> menuTreeList=getMenuTreeList(biMenuList,parents);
        return menuTreeList;
    }

    @Override
    public ResponseVo insertMenu(MenuVo menuVo) {
        //查询父亲节点
        BiMenu biMenu=biMenuListMapper.getByName(menuVo.getParentName(),null);
        //判断中文名是否重复
        BiMenu biMenu1=biMenuListMapper.getByName(menuVo.getMenuName(),"");
        if(biMenu1!=null){
            return ResponseVo.serviceFail("中文名称重复，新增失败");
        }
        //判断英文名是否重复
        BiMenu biMenu2=biMenuListMapper.getByName("",menuVo.getMenuEnname());
        if(biMenu2!=null){
            return ResponseVo.serviceFail("英文名称重复，新增失败");
        }
        BiMenu biMenu3=new BiMenu();
        biMenu3.setMenuEnname(menuVo.getMenuEnname());
        biMenu3.setMenuName(menuVo.getMenuName());
        biMenu3.setParentId(biMenu.getId());
        boolean flag= biMenuListMapper.insert(biMenu3)==1?true:false;
        if(flag){
            return ResponseVo.success("新增成功");
        }else {
            return ResponseVo.serviceFail("系统异常，请稍后再试");
        }
    }

    @Override
    public boolean updateMenu(MenuVo menuVo) {
        return false;
    }

    @Override
    public MenuVo getMenu(MenuVo menuVo) {
        return null;
    }

    @Override
    public boolean deleteMenu(MenuVo menuVo) {
        return biMenuListMapper.deleteByName(menuVo.getMenuName())==1?true:false;
    }

    private  List<MenuTree> getMenuTreeList(List<BiMenu> fullList,List<BiMenu> parentList){
        List<MenuTree> menuTreeList=parentList.stream().map(biMenu -> {
            MenuTree menuTree=new MenuTree();
            menuTree.setTitle(biMenu.getMenuName());
            menuTree.setMenuEnName(biMenu.getMenuEnname());
            List<BiMenu> children=fullList.stream().filter(biMenu1 ->
                    biMenu.getId().equals(biMenu1.getParentId())).collect(Collectors.toList());
            menuTree.setChildren(getMenuTreeList(fullList,children));
            return menuTree;
        }).collect(Collectors.toList());
        return menuTreeList;
    }
}
