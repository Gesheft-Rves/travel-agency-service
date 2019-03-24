package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TourCategory;

import java.util.List;

public interface TourCategoryService extends CrudService<TourCategory> {
    List<TourCategory> list();
}
