package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.AppUser;

import com.javastudents.travelagency.repository.AppUserRepository;

import com.javastudents.travelagency.service.PojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AppUserService implements PojoService<AppUser> {

    private final AppUserRepository repository;

    @Autowired
    public AppUserService(AppUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AppUser> list() {
        return repository.findAll();
    }

    @Override
    public AppUser getById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public AppUser save(AppUser obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(getById(id));
    }
}
