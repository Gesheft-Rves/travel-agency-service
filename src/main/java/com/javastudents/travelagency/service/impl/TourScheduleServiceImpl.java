package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.TourSchedule;
import com.javastudents.travelagency.repository.TourScheduleRepository;
import com.javastudents.travelagency.service.TourScheduleService;
import org.springframework.beans.factory.annotation.Autowired;

public class TourScheduleServiceImpl implements TourScheduleService {

    private final TourScheduleRepository repository;

    @Autowired
    public TourScheduleServiceImpl(TourScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(TourSchedule entity) {

    }

    @Override
    public TourSchedule read(int id) {
        return null;
    }

    @Override
    public void update(TourSchedule entity) {

    }

    @Override
    public void delete(int id) {

    }
}
