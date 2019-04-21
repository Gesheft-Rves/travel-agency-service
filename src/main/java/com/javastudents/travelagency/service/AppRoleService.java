package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.AppRole;
import com.javastudents.travelagency.repository.AppRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRoleService implements PojoService<AppRole> {

    private final AppRoleRepository repository;

    @Autowired
    public AppRoleService(AppRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AppRole> list() {
        return repository.findAll();
    }

    @Override
    public AppRole getById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public AppRole save(AppRole obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(getById(id));
    }
}
