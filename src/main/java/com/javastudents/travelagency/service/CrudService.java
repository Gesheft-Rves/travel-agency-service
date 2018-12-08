package com.javastudents.travelagency.service;


import com.javastudents.travelagency.entity.Entity;

public interface CrudService <T extends Entity> {

    void create(T entity);
    T read(int id);
    void update(T entity);
    void delete(int id);

}
