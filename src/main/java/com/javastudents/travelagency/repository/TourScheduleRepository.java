package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.TourSchedule;

import java.util.List;

public interface TourScheduleRepository extends CrudRepository<TourSchedule> {
    List<TourSchedule> list();
}
