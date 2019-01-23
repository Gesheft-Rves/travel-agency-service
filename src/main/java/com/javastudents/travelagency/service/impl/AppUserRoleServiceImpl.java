package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.AppUserRole;
import com.javastudents.travelagency.repository.AppUserRoleRepository;
import com.javastudents.travelagency.service.AppUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserRoleServiceImpl implements AppUserRoleService {

    private final AppUserRoleRepository repository;

    @Autowired
    public AppUserRoleServiceImpl(AppUserRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(AppUserRole appUserRole) {
        repository.create(appUserRole);
    }

    @Override
    public AppUserRole read(int appUserRoleId) {
        return repository.read(appUserRoleId);
    }

    @Override
    public void update(AppUserRole appUserRole) {
        repository.update(appUserRole);
    }

    @Override
    public void delete(int appUserRoleId) {
        repository.delete(appUserRoleId);
    }
}
