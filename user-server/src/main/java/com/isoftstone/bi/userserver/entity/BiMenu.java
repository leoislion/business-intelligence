package com.isoftstone.bi.userserver.entity;

public class BiMenu {
    private Long id;

    private String menuName;

    private Long parentId;

    private String menuEnname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMenuEnname() {
        return menuEnname;
    }

    public void setMenuEnname(String menuEnname) {
        this.menuEnname = menuEnname == null ? null : menuEnname.trim();
    }
}
