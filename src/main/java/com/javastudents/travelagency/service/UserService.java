package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.User;

import java.util.List;

public interface UserService extends PojoService<User> {
    List<User> list();
    User getById(Integer id);
    User save(User user);
    void delete(Integer id);
}
