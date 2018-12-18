package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.TransportSeat;
import com.javastudents.travelagency.repository.TransportSeatRepository;
import com.javastudents.travelagency.service.TransportSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportSeatServiceImpl implements TransportSeatService {

    private final TransportSeatRepository repository;

    @Autowired
    public TransportSeatServiceImpl(TransportSeatRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(TransportSeat transportSeat) {
        repository.create(transportSeat);
    }

    @Override
    public TransportSeat read(int transportSeatId) {
        return repository.read(transportSeatId);
    }

    @Override
    public void update(TransportSeat transportSeat) {
        repository.update(transportSeat);
    }

    @Override
    public void delete(int transportSeatId) {
        repository.delete(transportSeatId);
    }
}
