package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.Tour;

import java.util.List;

public interface TourService extends PojoService<Tour> {
    List<Tour> list();
    Tour getById(Integer id);
    Tour save(Tour obj);
    void delete(Integer id);
}
