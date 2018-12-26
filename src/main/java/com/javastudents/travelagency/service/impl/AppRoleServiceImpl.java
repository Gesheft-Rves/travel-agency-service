package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.AppRole;
import com.javastudents.travelagency.repository.AppRoleRepository;
import com.javastudents.travelagency.service.AppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppRoleServiceImpl implements AppRoleService {

    private final AppRoleRepository repository;

    @Autowired
    public AppRoleServiceImpl(AppRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(AppRole appRole) {
        repository.create(appRole);
    }

    @Override
    public AppRole read(int appRoleId) {
        return repository.read(appRoleId);
    }

    @Override
    public void update(AppRole appRole) {
        repository.update(appRole);
    }

    @Override
    public void delete(int appRoleId) {
        repository.delete(appRoleId);
    }
}
