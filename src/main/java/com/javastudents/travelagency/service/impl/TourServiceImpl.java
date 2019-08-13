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
    public List<Tour> list() {
        return repository.findAll();
    }

    @Override
    public Tour getById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public Tour save(Tour obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(getById(id));
    }
}
