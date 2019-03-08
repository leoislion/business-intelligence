package com.isoftstone.bi.userserver.service;

import com.isoftstone.bi.userserver.entity.BiUser;

/**
 * @Author: leo
 * @Date: 2019/2/12 17:37
 * @Version 0.0.1
 * @Desc 获取token
 */
public interface TokenService {
    /**
     *生成token
     *@param  user
     *@return  String
     *@author  leo
     *@date  2019/3/6
     */
    String getToken(BiUser user);

}
