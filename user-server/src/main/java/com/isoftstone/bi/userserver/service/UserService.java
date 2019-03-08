package com.isoftstone.bi.userserver.service;

import com.isoftstone.bi.userserver.entity.BiUser;
import com.isoftstone.bi.userserver.vo.UserVo;

import java.util.List;

/**
 * @Author: leo
 * @Date: 2019/2/12 16:10
 * @Version 0.0.1
 * @Desc  用户接口
 */
public interface UserService {
    /**
     *查询
     *@param  user
     *@return  BiUser
     *@author  leo
     *@date  2019/3/1
     */
    BiUser findUser(UserVo user);
    /**
     *根据id查询
     *@param  userId
     *@return  BiUser
     *@author  leo
     *@date  2019/3/1
     */
    BiUser findById(long userId);
    /**
     * 添加用户
     * @param biUser
     * @return boolean
     */
    boolean addUser(BiUser biUser);

    /**
     * 删除用户
     * @param userId
     * @return boolean
     */
    boolean deleteByUserId(int userId);

    /**
     * 批量删除
     * @author Mr.Huang
     * @param  biUserList
     * @return boolean
     */
    boolean deleteAllByUserIds(List<BiUser>  biUserList);

    /**
     * 查询用户
     * @param userName
     * @return Result<BiUser>
     */
    List<BiUser> queryUser(String userName);

    /**
     * 查询所有用户
     * @return Result<BiUser>
     */
    List<BiUser> queryUserAll();

    /**
     * 更新用户
     * @param record
     * @return Result<int>
     */
    int updateUser(BiUser record);
}
