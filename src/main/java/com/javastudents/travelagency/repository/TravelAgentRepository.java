package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.TravelAgent;

import java.util.List;

public interface TravelAgentRepository extends CrudRepository<TravelAgent> {
    List<TravelAgent> list();
}
