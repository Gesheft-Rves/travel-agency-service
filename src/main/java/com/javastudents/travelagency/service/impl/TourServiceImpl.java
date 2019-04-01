package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.Tour;
import com.javastudents.travelagency.repository.TourRepository;
import com.javastudents.travelagency.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements TourService {

    private final TourRepository repository;

    @Autowired
    public TourServiceImpl(TourRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Tour tour) {
        repository.create(tour);
    }

    @Override
    public Tour read(int tourId) {
        return repository.read(tourId);
    }

    @Override
    public void update(Tour tour) {
        repository.update(tour);
    }

    @Override
    public void delete(int tourId) {
        repository.delete(tourId);
    }

    @Override
    public List<Tour> list() {
        return repository.list();
    }
}
