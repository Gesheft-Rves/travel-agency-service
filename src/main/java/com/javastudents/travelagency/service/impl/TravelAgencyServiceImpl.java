package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.TravelAgency;
import com.javastudents.travelagency.repository.TravelAgencyRepository;
import com.javastudents.travelagency.service.TravelAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelAgencyServiceImpl implements TravelAgencyService {

    private final TravelAgencyRepository repository;

    @Autowired
    public TravelAgencyServiceImpl(TravelAgencyRepository repository) {
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
