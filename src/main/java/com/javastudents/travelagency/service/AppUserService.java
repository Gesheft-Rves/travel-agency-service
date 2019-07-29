package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.AppUser;

import com.javastudents.travelagency.repository.AppUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class AppUserService implements PojoService<AppUser>, UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername(@NotNull String str) throws UsernameNotFoundException {
        for (AppUser appUser : list()){
            if (appUser.getLogin().equals(str))
                return appUser;
        }
        throw new UsernameNotFoundException(str + " not found!");
    }
}
