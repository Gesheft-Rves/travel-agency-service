package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.TourCategory;
import com.javastudents.travelagency.repository.TourCategoryRepository;
import com.javastudents.travelagency.service.TourCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourCategoryServiceImpl implements TourCategoryService {

    private final TourCategoryRepository repository;

    @Autowired
    public TourCategoryServiceImpl(TourCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(TourCategory tourCategory) {
        repository.create(tourCategory);
    }

    @Override
    public TourCategory read(int tourCategoryId) {
        return repository.read(tourCategoryId);
    }

    @Override
    public void update(TourCategory tourCategory) {
        repository.update(tourCategory);
    }

    @Override
    public void delete(int tourCategoryId) {
        repository.delete(tourCategoryId);
    }
}
