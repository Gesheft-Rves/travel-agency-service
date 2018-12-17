package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.Transport;
import com.javastudents.travelagency.repository.TransportRepository;
import com.javastudents.travelagency.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;

public class TransportServiceImpl implements TransportService {

    private final TransportRepository repository;

    @Autowired
    public TransportServiceImpl(TransportRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Transport entity) {

    }

    @Override
    public Transport read(int id) {
        return null;
    }

    @Override
    public void update(Transport entity) {

    }

    @Override
    public void delete(int id) {

    }
}
