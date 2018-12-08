package com.javastudents.travelagency.repository;


import com.javastudents.travelagency.entity.Entity;

public interface CrudRepository <T extends Entity> {

    void create(T entity);
    T read(int id);
    void update(T entity);
    void delete(int id);

}
