package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.Tour;

import java.util.List;

public interface TourService extends CrudService<Tour> {
    List<Tour> list();
}
