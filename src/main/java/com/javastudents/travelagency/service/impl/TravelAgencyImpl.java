package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.TravelAgency;
import com.javastudents.travelagency.repository.TravelAgencyRepository;
import com.javastudents.travelagency.service.TravelAgencyService;

public class TravelAgencyImpl implements TravelAgencyService {

    private final TravelAgencyRepository repository;

    public TravelAgencyImpl(TravelAgencyRepository repository) {
        this.repository = repository;
    }


    @Override
    public void create(TravelAgency entity) {

    }

    @Override
    public TravelAgency read(int id) {
        return null;
    }

    @Override
    public void update(TravelAgency entity) {

    }

    @Override
    public void delete(int id) {

    }
}
