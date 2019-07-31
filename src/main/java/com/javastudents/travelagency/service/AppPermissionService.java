package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.AppPermission;
import com.javastudents.travelagency.repository.AppPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppPermissionService implements PojoService<AppPermission> {

    private final AppPermissionRepository repository;

    @Autowired
    public AppPermissionService(AppPermissionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AppPermission> list() {
        return repository.findAll();
    }

    @Override
    public AppPermission getById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public AppPermission save(AppPermission obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(getById(id));
    }
}
