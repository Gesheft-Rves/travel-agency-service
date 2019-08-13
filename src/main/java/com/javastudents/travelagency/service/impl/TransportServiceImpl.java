package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.Transport;
import com.javastudents.travelagency.repository.TransportRepository;
import com.javastudents.travelagency.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportServiceImpl implements TransportService {

    private final TransportRepository repository;

    @Autowired
    public TransportServiceImpl(TransportRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Transport> list() {
        return repository.findAll();
    }

    @Override
    public Transport getById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public Transport save(Transport obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(getById(id));
    }
}
