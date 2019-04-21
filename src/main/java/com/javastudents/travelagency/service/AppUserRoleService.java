package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.AppUserRole;
import com.javastudents.travelagency.repository.AppUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserRoleService implements PojoService<AppUserRole> {

    private final AppUserRoleRepository repository;

    @Autowired
    public AppUserRoleService(AppUserRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AppUserRole> list() {
        return repository.findAll();
    }

    @Override
    public AppUserRole getById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public AppUserRole save(AppUserRole obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(getById(id));
    }
}
