package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.TransportSeat;
import com.javastudents.travelagency.repository.TransportSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TransportSeatRepositoryImpl implements TransportSeatRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TransportSeatRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(TransportSeat entity) {

    }

    @Override
    public TransportSeat read(int id) {
        return null;
    }

    @Override
    public void update(TransportSeat entity) {

    }

    @Override
    public void delete(int id) {

    }
}
