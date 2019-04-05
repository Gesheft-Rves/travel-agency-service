package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.TravelAgent;
import com.javastudents.travelagency.repository.TravelAgentRepository;
import com.javastudents.travelagency.service.TravelAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelAgentServiceImpl implements TravelAgentService {

    private final TravelAgentRepository repository;

    @Autowired
    public TravelAgentServiceImpl(TravelAgentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(TravelAgent travelAgent) {
        repository.create(travelAgent);
    }

    @Override
    public TravelAgent read(int travelAgentId) {
        return repository.read(travelAgentId);
    }

    @Override
    public void update(TravelAgent travelAgent) {
        repository.update(travelAgent);
    }

    @Override
    public void delete(int travelAgentId) {
        repository.delete(travelAgentId);
    }

    @Override
    public List<TravelAgent> list() {
        return repository.list();
    }
}
