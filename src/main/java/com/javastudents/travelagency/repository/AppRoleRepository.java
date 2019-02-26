package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.AppRole;

import java.util.List;

public interface AppRoleRepository extends CrudRepository<AppRole> {
    List<AppRole> list();
}
