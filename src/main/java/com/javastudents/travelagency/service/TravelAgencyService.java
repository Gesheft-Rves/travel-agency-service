package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TravelAgency;

import java.util.List;

public interface TravelAgencyService extends CrudService<TravelAgency> {
    List<TravelAgency> list();
}
