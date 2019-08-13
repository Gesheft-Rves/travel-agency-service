package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TravelAgency;

import java.util.List;

public interface TravelAgencyService extends PojoService<TravelAgency>{
    List<TravelAgency> list();
    TravelAgency getById(Integer id);
    TravelAgency save(TravelAgency obj);
    void delete(Integer id);
}
