package com.isoftstone.bi.userserver.vo;

import com.isoftstone.bi.userserver.entity.BiUser;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: leo
 * @Date: 2019/2/12 17:52
 * @Version 0.0.1
 * @Desc
 */
@Data
public class UserVo implements Serializable {
    long userId;
    String userName;
    String userPassword;
    String token;
    String permission;
}
