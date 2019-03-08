package com.isoftstone.bi.userserver.service.impl;

import com.isoftstone.bi.userserver.entity.BiUser;
import com.isoftstone.bi.userserver.mapper.BiUserMapper;
import com.isoftstone.bi.userserver.service.UserService;
import com.isoftstone.bi.userserver.vo.UserVo;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @Author: leo
 * @Date: 2019/2/12 16:14
 * @Version 0.0.1
 * @Desc
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    BiUserMapper biUserMapper;
    @Override
    public BiUser findUser(UserVo user) {
        return biUserMapper.selectByNameAndPassword(user.getUserName(),user.getUserPassword());
    }

    @Override
    public BiUser findById(long userId) {
        return biUserMapper.selectByPrimaryKey(userId);
    }

    /**
     * @Desc: 新增用户
     * @Author: Mr.Huang
     * @Params: biUser
     * @Return: boolean
     */
    @Override
    public boolean addUser(BiUser biUser) {
        int num = biUserMapper.addUser(biUser);
        if(num != 0){
            return true;
        }
        return false;
    }

    /**
     * @Desc: 删除用户
     * @Author: Mr.Huang
     * @Params: id
     * @Return: boolean
     */
    @Override
    public boolean deleteByUserId(int userId) {
        return biUserMapper.deleteByUserId(userId);
    }

    /**
     * 批量删除
     *
     * @param biUserList
     * @return boolean
     * @author Mr.Huang
     */
    @Override
    public boolean deleteAllByUserIds(List<BiUser> biUserList) {
        List<Long> userIdsList = new ArrayList<>();
        biUserList.forEach(item->{userIdsList.add(item.getUserId());});
        return biUserMapper.deleteAllByUserIds(userIdsList);
    }

    /**
     * @Desc: 用户查询
     * @Author: Mr.Huang
     * @Params: [userName]
     * @Return:  List<BiUser>
     */
    @Override
    public  List<BiUser> queryUser(String userName) {
        return biUserMapper.queryUser(userName);
    }

    /**
     * @Desc:  查询所有用户
     * @Author: Mr.Huang
     * @Return: List<BiUser>
     */
    @Override
    public List<BiUser> queryUserAll() {
        return biUserMapper.queryUserAll();
    }

    /**
     * 更新用户
     *
     * @param record
     * @return Result<int>
     */
    @Override
    public int updateUser(BiUser record) {
        return biUserMapper.updateUser(record);
    }
}
