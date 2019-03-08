package com.isoftstone.bi.userserver.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.isoftstone.bi.userserver.entity.BiUser;

/**
 * @Author: leo
 * @Date: 2019/2/12 16:03
 * @Version 0.0.1
 * @Desc jwt工具类
 */
public class JwtUtil {

    public static String getToken(BiUser user){
        String token="";
        token= JWT.create().withClaim("id",user.getUserId()).withClaim("name",user.getUserName())
                .sign(Algorithm.HMAC256(user.getUserPassword()));
        return token;
    }

}
