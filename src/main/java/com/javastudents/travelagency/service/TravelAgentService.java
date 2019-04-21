package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TravelAgent;
import com.javastudents.travelagency.repository.TravelAgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelAgentService implements PojoService<TravelAgent> {

    private TravelAgentRepository repository;

    @Autowired
    public void setRepository(TravelAgentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TravelAgent> list() {
        return repository.findAll();
    }

    @Override
    public TravelAgent getById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public TravelAgent save(TravelAgent obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(getById(id));
    }
}
