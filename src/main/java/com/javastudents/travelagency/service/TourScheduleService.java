package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TourSchedule;

import java.util.List;

public interface TourScheduleService extends CrudService<TourSchedule> {
    List<TourSchedule> list();
}
