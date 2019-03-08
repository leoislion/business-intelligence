package com.isoftstone.bi.userserver.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.isoftstone.bi.userserver.entity.BiUser;
import com.isoftstone.bi.userserver.service.TokenService;
import org.springframework.stereotype.Service;

/**
 * @Author: leo
 * @Date: 2019/2/12 17:38
 * @Version 0.0.1
 * @Desc
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public String getToken(BiUser user) {
        String token="";
        // 将 user id 保存到 token 里面,以 password 作为 token 的密钥
        token=  JWT.create().withAudience(user.getUserId()+"")
                .sign(Algorithm.HMAC256(user.getUserPassword()));
        return token;
    }
}
