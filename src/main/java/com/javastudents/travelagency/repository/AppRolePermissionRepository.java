package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.AppRolePermission;
import com.javastudents.travelagency.entity.wrapper.AppRolePermissionWrapper;

import java.util.List;

public interface AppRolePermissionRepository extends CrudRepository<AppRolePermission> {
    List<AppRolePermission> list ();
    List<AppRolePermissionWrapper> appRolePermissionWrapperList();
    AppRolePermissionWrapper readAppRolePermissionWrapper(Integer appRolePermissionId);
}
