package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TravelAgent;

import java.util.List;

public interface TravelAgentService extends CrudService<TravelAgent> {
    List<TravelAgent> list();
}
