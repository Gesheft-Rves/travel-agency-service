package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.AppRolePermission;
import com.javastudents.travelagency.entity.wrapper.AppRolePermissionWrapper;

import java.util.List;

public interface AppRolePermissionService extends CrudService<AppRolePermission> {
    List<AppRolePermission> list ();
    List<AppRolePermissionWrapper> appRolePermissionWrapperList();
    AppRolePermissionWrapper readAppRolePermissionWrapper(Integer appRolePermissionId);
}
