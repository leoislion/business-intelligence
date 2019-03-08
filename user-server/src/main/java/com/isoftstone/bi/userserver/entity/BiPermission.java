package com.isoftstone.bi.userserver.entity;

public class BiPermission {
    private Long permissionId;

    private String permissionName;

    private String permissionUrl;

    private Long parentId;

    private Long roleId;

    private String permissionAuth;

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl == null ? null : permissionUrl.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getPermissionAuth() {
        return permissionAuth;
    }

    public void setPermissionAuth(String permissionAuth) {
        this.permissionAuth = permissionAuth == null ? null : permissionAuth.trim();
    }
}