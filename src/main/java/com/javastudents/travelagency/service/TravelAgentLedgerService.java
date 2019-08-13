package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TravelAgentLedger;

import java.util.List;

public interface TravelAgentLedgerService extends PojoService<TravelAgentLedger> {
    List<TravelAgentLedger> list();
    TravelAgentLedger getById(Integer id);
    TravelAgentLedger save(TravelAgentLedger obj);
    void delete(Integer id);
}
