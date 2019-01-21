package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.TravelAgentLedger;
import com.javastudents.travelagency.repository.TravelAgentLedgerRepository;
import com.javastudents.travelagency.service.TravelAgentLedgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelAgentLedgerServiceImpl implements TravelAgentLedgerService {

    private final TravelAgentLedgerRepository repository;

    @Autowired
    public TravelAgentLedgerServiceImpl(TravelAgentLedgerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(TravelAgentLedger travelAgentLedger) {
        repository.create(travelAgentLedger);
    }

    @Override
    public TravelAgentLedger read(int travelAgentLedgerId) {
        return repository.read(travelAgentLedgerId);
    }

    @Override
    public void update(TravelAgentLedger travelAgentLedger) {
        repository.update(travelAgentLedger);
    }

    @Override
    public void delete(int travelAgentLedgerId) {
        repository.delete(travelAgentLedgerId);
    }
}
