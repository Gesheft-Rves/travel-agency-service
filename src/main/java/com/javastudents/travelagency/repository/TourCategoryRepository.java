package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.TourCategory;

import java.util.List;

public interface TourCategoryRepository extends CrudRepository<TourCategory> {
    List<TourCategory> list();
}
