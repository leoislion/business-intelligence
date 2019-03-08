package com.isoftstone.bi.userserver.mapper;

import com.isoftstone.bi.userserver.entity.BiMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Author: leo
 * @Date: 2019/2/25 16:16
 * @Version 0.0.1
 * @Desc 系统菜单mapper
 */
public interface BiMenuListMapper {
    /**
     * 根据Id查询
     *@param  id
     *@return  int
     *@author  leo
     *@date  2019/2/25
     */
    int deleteByPrimaryKey(Long id);
    /**
     *新增
     *@param  record
     *@return  int
     *@author  leo
     *@date  2019/2/25
     */
    int insert(BiMenu record);
    /**
     *条件新增
     *@param  record
     *@return  int
     *@author  leo
     *@date  2019/2/25
     */
    int insertSelective(BiMenu record);
    /**
     *id查询
     *@param  id
     *@return  BiMenu
     *@author  leo
     *@date  2019/2/25
     */
    BiMenu selectByPrimaryKey(Long id);
    /**
     * id选择性更新
     *@param  record
     *@return  int
     *@author  leo
     *@date  2019/2/25
     */
    int updateByPrimaryKeySelective(BiMenu record);
    /**
     *id更新记录
     *@param  record
     *@return  int
     *@author  leo
     *@date  2019/2/25
     */
    int updateByPrimaryKey(BiMenu record);
    /**
     *菜单列表查询
     *@param
     *@return  List<BiMenu>
     *@author  leo
     *@date  2019/2/25
     */
    List<BiMenu> list();
    /**
     *通过菜单名称查询记录
     *@param  menuName
     *@param  menuEnName
     *@return  BiMenu
     *@author  leo
     *@date  2019/2/27
     */
    BiMenu getByName(@Param("menuName")String menuName,@Param("menuEnName")String menuEnName);
    /**
     *根据菜单名称删除
     *@param  menuName
     *@return  int
     *@author  leo
     *@date  2019/2/28
     */
    int deleteByName(@Param("menuName")String menuName);
}
