package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.AppPermission;

import java.util.List;

public interface AppPermissionRepository extends CrudRepository<AppPermission> {
    List<AppPermission> list ();
}
