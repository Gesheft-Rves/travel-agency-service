package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.TravelAgentLedger;
import com.javastudents.travelagency.repository.TravelAgentLedgerRepository;
import com.javastudents.travelagency.service.TravelAgentLedgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelAgentLedgerServiceImpl implements TravelAgentLedgerService {

    private final TravelAgentLedgerRepository repository;

    @Autowired
    public TravelAgentLedgerServiceImpl(TravelAgentLedgerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TravelAgentLedger> list() {
        return repository.findAll();
    }

    @Override
    public TravelAgentLedger getById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public TravelAgentLedger save(TravelAgentLedger obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(getById(id));
    }
}
