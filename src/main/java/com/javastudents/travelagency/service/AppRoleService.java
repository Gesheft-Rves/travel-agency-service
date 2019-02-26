package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.AppRole;

import java.util.List;

public interface AppRoleService extends CrudService<AppRole> {
    List<AppRole> list();
}
