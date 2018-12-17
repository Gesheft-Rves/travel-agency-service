package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.Tour;
import com.javastudents.travelagency.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TourRepositoryImpl implements TourRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TourRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Tour tour) {

    }

    @Override
    public Tour read(int turId) {
        return null;
    }

    @Override
    public void update(Tour tour) {

    }

    @Override
    public void delete(int tourId) {

    }
}
