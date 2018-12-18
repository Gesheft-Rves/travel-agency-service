package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.Transport;
import com.javastudents.travelagency.repository.TransportRepository;
import com.javastudents.travelagency.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportServiceImpl implements TransportService {

    private final TransportRepository repository;

    @Autowired
    public TransportServiceImpl(TransportRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Transport transport) {
        repository.create(transport);
    }

    @Override
    public Transport read(int transportId) {
        return repository.read(transportId);
    }

    @Override
    public void update(Transport transport) {
        repository.update(transport);
    }

    @Override
    public void delete(int transportId) {
        repository.delete(transportId);
    }
}
