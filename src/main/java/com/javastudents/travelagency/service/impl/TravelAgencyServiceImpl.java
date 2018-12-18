package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.TravelAgency;
import com.javastudents.travelagency.repository.TravelAgencyRepository;
import com.javastudents.travelagency.service.TravelAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelAgencyServiceImpl implements TravelAgencyService {

    private final TravelAgencyRepository repository;

    @Autowired
    public TravelAgencyServiceImpl(TravelAgencyRepository repository) {
        this.repository = repository;
    }


    @Override
    public void create(TravelAgency travelAgency) {
        repository.create(travelAgency);
    }

    @Override
    public TravelAgency read(int travelAgencyId) {
        return repository.read(travelAgencyId);
    }

    @Override
    public void update(TravelAgency travelAgency) {
        repository.update(travelAgency);
    }

    @Override
    public void delete(int travelAgencyId) {
        repository.delete(travelAgencyId);
    }
}
