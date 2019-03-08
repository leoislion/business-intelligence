package com.isoftstone.bi.userserver.service;

import com.isoftstone.bi.userserver.entity.BiMenu;
import com.isoftstone.bi.userserver.vo.MenuTree;
import com.isoftstone.bi.userserver.vo.MenuVo;
import com.isoftstone.bi.userserver.vo.ResponseVo;

import java.util.List;

/**
 * @Author: leo
 * @Date: 2019/2/25 16:16
 * @Version 0.0.1
 * @Desc 系统菜单接口
 */
public interface BiSystemMenuService {
    /**
     *查询菜单树
     *@param
     *@return  List<MenuTree>
     *@author  leo
     *@date  2019/2/25
     */
    List<MenuTree> getMenuTree();
    /**
     *新增菜单
     *@param  menuVo
     *@return  boolean
     *@author  leo
     *@date  2019/2/25
     */
    ResponseVo insertMenu(MenuVo menuVo);
    /**
     *更新菜单
     *@param  menuVo
     *@return  boolean
     *@author  leo
     *@date  2019/2/25
     */
    boolean updateMenu(MenuVo menuVo);
    /**
     *查询菜单
     *@param  menuVo
     *@return  boolean
     *@author  leo
     *@date  2019/2/25
     */
    MenuVo getMenu(MenuVo menuVo);
    /**
     *删除菜单
     *@param  menuVo
     *@return  boolean
     *@author  leo
     *@date  2019/2/25
     */
    boolean deleteMenu(MenuVo menuVo);

}
