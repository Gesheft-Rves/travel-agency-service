package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.TourSchedule;
import com.javastudents.travelagency.repository.TourScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TourScheduleRepositoryImpl implements TourScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TourScheduleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(TourSchedule tourSchedule) {

    }

    @Override
    public TourSchedule read(int tourScheduleId) {
        return null;
    }

    @Override
    public void update(TourSchedule tourSchedule) {

    }

    @Override
    public void delete(int tourScheduleId) {

    }
}
