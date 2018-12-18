package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.TravelAgency;
import com.javastudents.travelagency.repository.TravelAgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TravelAgencyRepositoryImpl implements TravelAgencyRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TravelAgencyRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void create(TravelAgency travelAgency) {

    }

    @Override
    public TravelAgency read(int travelAgencyId) {
        return null;
    }

    @Override
    public void update(TravelAgency travelAgency) {

    }

    @Override
    public void delete(int travelAgencyId) {

    }
}
