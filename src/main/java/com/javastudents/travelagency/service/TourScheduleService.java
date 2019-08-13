package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TourSchedule;

import java.util.List;

public interface TourScheduleService extends PojoService<TourSchedule> {
    List<TourSchedule> list();
    TourSchedule getById(Integer id);
    TourSchedule save(TourSchedule obj);
    void delete(Integer id);
}
