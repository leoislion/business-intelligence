package com.isoftstone.bi.userserver.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: leo
 * @Date: 2019/2/25 15:54
 * @Version 0.0.1
 * @Desc 菜单树
 */
@Data
public class MenuTree implements Serializable {
    private String title;

    private boolean expand=true;

    private List<MenuTree> children;

    private boolean checked=false;

    private Long roleId;

    private String menuEnName;

}
