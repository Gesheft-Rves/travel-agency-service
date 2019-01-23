package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.AppUser;
import com.javastudents.travelagency.repository.AppUserRepository;
import com.javastudents.travelagency.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository repository;

    @Autowired
    public AppUserServiceImpl(AppUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(AppUser appUser) {
        repository.create(appUser);
    }

    @Override
    public AppUser read(int appUserId) {
        return repository.read(appUserId);
    }

    @Override
    public void update(AppUser appUser) {
        repository.update(appUser);
    }

    @Override
    public void delete(int appUserId) {
        repository.delete(appUserId);
    }
}
