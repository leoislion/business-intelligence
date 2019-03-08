package com.isoftstone.bi.userserver.mapper;

import com.isoftstone.bi.userserver.entity.BiUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: leo
 * @Date: 2019/2/25 16:16
 * @Version 0.0.1
 * @Desc 用户mapper
 */
public interface BiUserMapper {
    /**
     *删除
     *@param  userId
     *@return  int
     *@author  leo
     *@date  2019/3/1
     */
    int deleteByPrimaryKey(Long userId);
    /**
     *新增
     *@param  record
     *@return  int
     *@author  leo
     *@date  2019/3/1
     */
    int insert(BiUser record);
    /**
     *新增
     *@param  record
     *@return  int
     *@author  leo
     *@date  2019/3/1
     */
    int insertSelective(BiUser record);
    /**
     *查询
     *@param  userId
     *@return  BiUser
     *@author  leo
     *@date  2019/3/1
     */
    BiUser selectByPrimaryKey(Long userId);
    /**
     *更新
     *@param  record
     *@return  int
     *@author  leo
     *@date  2019/3/1
     */
    int updateByPrimaryKeySelective(BiUser record);
    /**
     *更新
     *@param  record
     *@return  int
     *@author  leo
     *@date  2019/3/1
     */
    int updateByPrimaryKey(BiUser record);
    /**
     *查询
     *@param  userName
     *@param password
     *@return  BiUser
     *@author  leo
     *@date  2019/3/1
     */
    BiUser selectByNameAndPassword(@Param("userName") String userName,@Param("userPassword") String password);

    /**
     * 用户查询
     * @param userName
     * @return BiUser
     */
    List<BiUser> queryUser(String userName);

    /**
     * 查询所有用户
     * @return List<BiUser>
     */
    List<BiUser> queryUserAll();

    /**
     * 用户删除
     * @author Mr.Huang
     * @param  userId
     * @return boolean
     */
    boolean deleteByUserId(int  userId);
    /**
     * 批量删除
     * @author Mr.Huang
     * @param  userIdsList
     * @return boolean
     */
    boolean deleteAllByUserIds(List<Long>  userIdsList);

    /**
     * 更新用户
     * @author Mr.Huang
     * @param  biUser
     * @return int
     */
    int updateUser(BiUser biUser);

    /**
     * 新增用户
     * @author Mr.Huang
     * @param  biUser
     * @return int
     */
    int addUser(BiUser biUser);

}
