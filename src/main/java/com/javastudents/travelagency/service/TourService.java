package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.Tour;
import com.javastudents.travelagency.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService implements PojoService<Tour> {
    private TourRepository repository;

    @Autowired
    public void setRepository(TourRepository repository) {
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
