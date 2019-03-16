package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.Tour;

import java.util.List;

public interface TourRepository extends CrudRepository<Tour> {
    List<Tour> list();
}
