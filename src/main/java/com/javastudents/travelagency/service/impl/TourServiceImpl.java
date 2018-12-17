package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.Tour;
import com.javastudents.travelagency.repository.TourScheduleRepository;
import com.javastudents.travelagency.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;

public class TourServiceImpl implements TourService {

    private final TourScheduleRepository repository;

    @Autowired
    public TourServiceImpl(TourScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Tour entity) {

    }

    @Override
    public Tour read(int id) {
        return null;
    }

    @Override
    public void update(Tour entity) {

    }

    @Override
    public void delete(int id) {

    }
}
