package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.TourSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourScheduleRepository extends JpaRepository<TourSchedule,Integer> {
}
