package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.Tour;
import com.javastudents.travelagency.entity.wrapper.TourWrapper;

import java.util.List;

public interface TourRepository extends CrudRepository<Tour> {
    List<Tour> list();
    List<TourWrapper> listWrapper();
    TourWrapper readWrapper();
}
