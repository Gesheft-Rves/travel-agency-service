package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.TourCategory;
import com.javastudents.travelagency.repository.TourCategoryRepository;
import com.javastudents.travelagency.service.TourCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class TourCategoryServiceImpl implements TourCategoryService {

    private final TourCategoryRepository repository;

    @Autowired
    public TourCategoryServiceImpl(TourCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(TourCategory entity) {

    }

    @Override
    public TourCategory read(int id) {
        return null;
    }

    @Override
    public void update(TourCategory entity) {

    }

    @Override
    public void delete(int id) {

    }
}
