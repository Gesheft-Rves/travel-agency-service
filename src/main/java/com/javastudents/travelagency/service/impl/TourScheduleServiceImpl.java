package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.TourSchedule;
import com.javastudents.travelagency.repository.TourScheduleRepository;
import com.javastudents.travelagency.service.TourScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourScheduleServiceImpl implements TourScheduleService {

    private final TourScheduleRepository repository;

    @Autowired
    public TourScheduleServiceImpl(TourScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(TourSchedule tourSchedule) {
        repository.create(tourSchedule);
    }

    @Override
    public TourSchedule read(int tourScheduleId) {
        return repository.read(tourScheduleId);
    }

    @Override
    public void update(TourSchedule tourSchedule) {
        repository.update(tourSchedule);
    }

    @Override
    public void delete(int tourScheduleId) {
        repository.delete(tourScheduleId);
    }
}
