package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.TravelAgency;
import com.javastudents.travelagency.repository.TravelAgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TravelAgencyImpl implements TravelAgencyRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TravelAgencyImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void create(TravelAgency entity) {

    }

    @Override
    public TravelAgency read(int id) {
        return null;
    }

    @Override
    public void update(TravelAgency entity) {

    }

    @Override
    public void delete(int id) {

    }
}
