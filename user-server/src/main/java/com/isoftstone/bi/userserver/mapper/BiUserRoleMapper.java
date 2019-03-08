package com.isoftstone.bi.userserver.mapper;

import com.isoftstone.bi.userserver.entity.BiUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: leo
 * @Date: 2019/2/28 15:54
 * @Version 0.0.1
 * @Desc 用户角色mapper
 */
public interface BiUserRoleMapper {
    /**
     *删除
     *@param  id
     *@return  int
     *@author  leo
     *@date  2019/3/1
     */
    int deleteByPrimaryKey(Long id);
    /**
     *新增
     *@param record
     *@return int
     *@author  leo
     *@date  2019/3/1
     */
    int insert(BiUserRole record);
    /**
     *新增
     *@param  record
     *@return  int
     *@author  leo
     *@date  2019/3/1
     */
    int insertSelective(BiUserRole record);
    /**
     *查询
     *@param  id
     *@return  BiUserRole
     *@author  leo
     *@date  2019/3/1
     */
    BiUserRole selectByPrimaryKey(Long id);
    /**
     *更新
     *@param  record
     *@return  int
     *@author  leo
     *@date  2019/3/1
     */
    int updateByPrimaryKeySelective(BiUserRole record);
    /**
     *更新
     *@param  record
     *@return  int
     *@author  leo
     *@date  2019/3/1
     */
    int updateByPrimaryKey(BiUserRole record);
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
    /**
     *根据userId查找
     *@param  userId
     *@return  BiUserRole
     *@author  leo
     *@date  2019/3/6
     */
    BiUserRole getByUserId(@Param("userId")Long userId);
}
