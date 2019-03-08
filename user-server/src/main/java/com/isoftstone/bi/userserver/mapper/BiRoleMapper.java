package com.isoftstone.bi.userserver.mapper;

import com.isoftstone.bi.userserver.entity.BiRole;

import java.util.List;
/**
 * @Author: leo
 * @Date: 2019/2/28 15:54
 * @Version 0.0.1
 * @Desc 角色相关mapper
 */
public interface BiRoleMapper {
    /**
     *根据Id删除记录
     *@param  roleId
     *@return  int
     *@author  leo
     *@date  2019/3/1
     */
    int deleteByPrimaryKey(Long roleId);
    /**
     *新增
     *@param  record
     *@return  int
     *@author  leo
     *@date  2019/3/1
     */
    int insert(BiRole record);
    /**
     *新增
     *@param  record
     *@return  int
     *@author  leo
     *@date  2019/3/1
     */
    int insertSelective(BiRole record);
    /**
     *根据Id查找记录
     *@param  roleId
     *@return  BiRole
     *@author  leo
     *@date  2019/3/1
     */
    BiRole selectByPrimaryKey(Long roleId);
    /**
     *更新记录
     *@param  record
     *@return  int
     *@author  leo
     *@date  2019/3/1
     */
    int updateByPrimaryKeySelective(BiRole record);
    /**
     *更新记录
     *@param  record
     *@return  int
     *@author  leo
     *@date  2019/3/1
     */
    int updateByPrimaryKey(BiRole record);

    /**
     *  新增角色
     * @author  Mr.Huang
     * @param biRole
     * @return Result<int>
     */
    int addRole(BiRole biRole);

    /**
     *   删除角色
     * @author Mr.Huang
     * @param  id
     * @return Result<XxxxDO>
     */

    boolean deleteByRoleId(int id);

    /**
     * 批量删除
     * @author Mr.Huang
     * @param  roleIdsList
     * @return boolean
     */
    boolean deleteAll(List<Long>  roleIdsList);

    /**
     *   查询角色
     * @author Mr.Huang
     * @param roleName
     * @return Result<BiRole>
     */
    List<BiRole> queryRole(String roleName);

    /**
     *   查询多个角色
     * @author Mr.Huang
     * @param biRole
     * @return  List<BiRole>
     */
    List<BiRole> queryRoleIds(BiRole biRole);

    /**
     *   查询所有角色
     * @author Mr.Huang
     * @return Result<BiRole>
     */
    List<BiRole> queryRoleAll();
}
