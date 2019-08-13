package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.TransportSeat;
import com.javastudents.travelagency.repository.TransportSeatRepository;
import com.javastudents.travelagency.service.TransportSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportSeatServiceImpl implements TransportSeatService {

    private final TransportSeatRepository repository;

    @Autowired
    public TransportSeatServiceImpl(TransportSeatRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TransportSeat> list() {
        return repository.findAll();
    }

    @Override
    public TransportSeat getById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public TransportSeat save(TransportSeat obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(getById(id));
    }
}
