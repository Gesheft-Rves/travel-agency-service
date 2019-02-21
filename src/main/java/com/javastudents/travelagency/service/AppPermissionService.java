package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.AppPermission;

import java.util.List;

public interface AppPermissionService extends CrudService<AppPermission> {
    List<AppPermission> list ();
}
