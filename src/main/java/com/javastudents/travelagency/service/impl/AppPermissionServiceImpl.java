package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.AppPermission;
import com.javastudents.travelagency.repository.AppPermissionRepository;
import com.javastudents.travelagency.service.AppPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppPermissionServiceImpl implements AppPermissionService {

    private final AppPermissionRepository repository;

    @Autowired
    public AppPermissionServiceImpl(AppPermissionRepository repository) {
        this.repository = repository;
    }


    @Override
    public void create(AppPermission appPermission) {
        repository.create(appPermission);
    }

    @Override
    public AppPermission read(int appPermissionId) {
        return repository.read(appPermissionId);
    }

    @Override
    public void update(AppPermission appPermission) {
        repository.update(appPermission);
    }

    @Override
    public void delete(int appPermissionId) {
        repository.delete(appPermissionId);
    }
}
