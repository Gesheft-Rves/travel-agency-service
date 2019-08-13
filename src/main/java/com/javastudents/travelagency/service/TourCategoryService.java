package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TourCategory;

import java.util.List;

public interface TourCategoryService extends PojoService<TourCategory>{
    List<TourCategory> list();
    TourCategory getById(Integer id);
    TourCategory save(TourCategory obj);
    void delete(Integer id);
}
