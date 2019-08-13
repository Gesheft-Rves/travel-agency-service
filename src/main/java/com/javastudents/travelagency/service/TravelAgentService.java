package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TravelAgent;

import java.util.List;

public interface TravelAgentService extends PojoService<TravelAgent> {
    List<TravelAgent> list();
    TravelAgent getById(Integer id);
    TravelAgent save(TravelAgent obj);
    void delete(Integer id);
}
