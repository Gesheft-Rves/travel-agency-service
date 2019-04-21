package com.javastudents.travelagency.service;

import java.util.List;

public interface PojoService<T> {
    List<T> list();
    T getById(Integer id);
    T save(T obj);
    void delete(Integer id);
}

