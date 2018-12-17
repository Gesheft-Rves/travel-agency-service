package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.TourCategory;
import com.javastudents.travelagency.repository.TourCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TourCategoryRepositoryImpl implements TourCategoryRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TourCategoryRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(TourCategory tourCategory) {

    }

    @Override
    public TourCategory read(int tourCategoryId) {
        return null;
    }

    @Override
    public void update(TourCategory tourCategory) {

    }

    @Override
    public void delete(int tourCategoryId) {

    }
}
