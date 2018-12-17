package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.repository.TravelAgentRepository;
import com.javastudents.travelagency.service.TravelAgentService;
import org.springframework.beans.factory.annotation.Autowired;

public class TravelAgentServiceImpl implements TravelAgentService {

    private final TravelAgentRepository repository;

    @Autowired
    public TravelAgentServiceImpl(TravelAgentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(com.javastudents.travelagency.entity.TravelAgent entity) {

    }

    @Override
    public com.javastudents.travelagency.entity.TravelAgent read(int id) {
        return null;
    }

    @Override
    public void update(com.javastudents.travelagency.entity.TravelAgent entity) {

    }

    @Override
    public void delete(int id) {

    }
}
