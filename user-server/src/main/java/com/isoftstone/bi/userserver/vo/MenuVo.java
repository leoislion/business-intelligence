package com.isoftstone.bi.userserver.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: leo
 * @Date: 2019/2/25 16:27
 * @Version 0.0.1
 * @Desc
 */
@Data
public class MenuVo implements Serializable {
    private Long id;

    private String menuName;

    private Long parentId;

    private String menuEnname;

    private String parentName;

}
