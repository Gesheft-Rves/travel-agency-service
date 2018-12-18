package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.TravelAgent;
import com.javastudents.travelagency.repository.TravelAgentRepository;
import com.javastudents.travelagency.service.TravelAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelAgentServiceImpl implements TravelAgentService {

    private final TravelAgentRepository repository;

    @Autowired
    public TravelAgentServiceImpl(TravelAgentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(TravelAgent travelAgent) {

    }

    @Override
    public TravelAgent read(int travelAgentId) {
        return null;
    }

    @Override
    public void update(TravelAgent travelAgent) {

    }

    @Override
    public void delete(int travelAgentId) {

    }
}
