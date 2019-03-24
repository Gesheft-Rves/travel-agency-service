package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.TravelAgency;

import java.util.List;

public interface TravelAgencyRepository extends CrudRepository<TravelAgency> {
    List<TravelAgency> list();
}
