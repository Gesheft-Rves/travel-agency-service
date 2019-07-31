package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TravelAgency;
import com.javastudents.travelagency.repository.TravelAgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelAgencyService implements PojoService<TravelAgency> {

    private final TravelAgencyRepository repository;

    @Autowired
    public TravelAgencyService(TravelAgencyRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TravelAgency> list() {
        return repository.findAll();
    }

    @Override
    public TravelAgency getById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public TravelAgency save(TravelAgency obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(getById(id));
    }
}
