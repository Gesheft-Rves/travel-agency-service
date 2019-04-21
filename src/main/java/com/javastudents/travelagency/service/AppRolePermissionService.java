package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.AppRolePermission;
import com.javastudents.travelagency.repository.AppRolePermissionRepository;
import com.javastudents.travelagency.service.PojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRolePermissionService implements PojoService<AppRolePermission> {

    private final AppRolePermissionRepository repository;

    @Autowired
    public AppRolePermissionService(AppRolePermissionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AppRolePermission> list() {
        return repository.findAll();
    }

    @Override
    public AppRolePermission getById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public AppRolePermission save(AppRolePermission obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(getById(id));
    }
}
