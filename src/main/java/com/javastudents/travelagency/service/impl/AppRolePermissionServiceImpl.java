package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.AppRolePermission;
import com.javastudents.travelagency.repository.AppRolePermissionRepository;
import com.javastudents.travelagency.service.AppRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppRolePermissionServiceImpl implements AppRolePermissionService {

    private final AppRolePermissionRepository repository;

    @Autowired
    public AppRolePermissionServiceImpl(AppRolePermissionRepository repository) {
        this.repository = repository;
    }


    @Override
    public void create(AppRolePermission appRolePermission) {
        repository.create(appRolePermission);
    }

    @Override
    public AppRolePermission read(int appRolePermissionId) {
        return repository.read(appRolePermissionId);
    }

    @Override
    public void update(AppRolePermission appRolePermission) {
        repository.update(appRolePermission);
    }

    @Override
    public void delete(int appRolePermissionId) {
        repository.delete(appRolePermissionId);
    }
}
