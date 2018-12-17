package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.TravelAgentLedger;
import com.javastudents.travelagency.repository.TravelAgentLedgerRepository;
import com.javastudents.travelagency.service.TravelAgentLedgerService;
import org.springframework.beans.factory.annotation.Autowired;

public class TravelAgentLedgerServiceImpl implements TravelAgentLedgerService {

    private final TravelAgentLedgerRepository repository;

    @Autowired
    public TravelAgentLedgerServiceImpl(TravelAgentLedgerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(TravelAgentLedger entity) {

    }

    @Override
    public TravelAgentLedger read(int id) {
        return null;
    }

    @Override
    public void update(TravelAgentLedger entity) {

    }

    @Override
    public void delete(int id) {

    }
}
