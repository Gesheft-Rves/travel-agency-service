package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.TourSchedule;
import com.javastudents.travelagency.repository.TourScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TourScheduleRepositoryImpl implements TourScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TourScheduleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(TourSchedule entity) {

    }

    @Override
    public TourSchedule read(int id) {
        return null;
    }

    @Override
    public void update(TourSchedule entity) {

    }

    @Override
    public void delete(int id) {

    }
}
