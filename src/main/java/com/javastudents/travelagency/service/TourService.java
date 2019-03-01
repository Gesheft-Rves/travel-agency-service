package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.Tour;
import com.javastudents.travelagency.entity.wrapper.TourWrapper;

import java.util.List;

public interface TourService extends CrudService<Tour> {
    List<Tour> list();
    List<TourWrapper> listWrapper();
    TourWrapper readWrapper(int id);
}
