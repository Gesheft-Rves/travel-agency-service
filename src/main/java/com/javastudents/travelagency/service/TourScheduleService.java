package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TourSchedule;
import com.javastudents.travelagency.repository.TourScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourScheduleService implements PojoService<TourSchedule> {

    private final TourScheduleRepository repository;

    @Autowired
    public TourScheduleService(TourScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TourSchedule> list() {
        return repository.findAll();
    }

    @Override
    public TourSchedule getById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public TourSchedule save(TourSchedule obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(getById(id));
    }
}
