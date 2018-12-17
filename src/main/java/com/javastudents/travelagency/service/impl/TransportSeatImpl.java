package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.TransportSeat;
import com.javastudents.travelagency.repository.TransportSeatRepository;
import com.javastudents.travelagency.service.TransportSeatService;
import org.springframework.beans.factory.annotation.Autowired;

public class TransportSeatImpl implements TransportSeatService {

    private final TransportSeatRepository repository;

    @Autowired
    public TransportSeatImpl(TransportSeatRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(TransportSeat entity) {

    }

    @Override
    public TransportSeat read(int id) {
        return null;
    }

    @Override
    public void update(TransportSeat entity) {

    }

    @Override
    public void delete(int id) {

    }
}
