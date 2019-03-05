package com.javastudents.travelagency.entity;

import lombok.*;


@Builder
@ToString
@Getter @Setter
@EqualsAndHashCode
public class AppRolePermission implements Entity {
    private Integer appRolePermissionId;
    private Integer appRoleId;
    private Integer appPermissionId;

    public AppRolePermission(Integer appRolePermissionId, Integer appRoleId, Integer appPermissionId) {
        this.appRolePermissionId = appRolePermissionId;
        this.appRoleId = appRoleId;
        this.appPermissionId = appPermissionId;
    }

    public AppRolePermission() {
    }
}
