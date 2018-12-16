package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.TravelAgent;
import com.javastudents.travelagency.repository.TravelAgentRepository;
import org.springframework.jdbc.core.JdbcTemplate;

public class TravelAgentImpl implements TravelAgentRepository {

    private final JdbcTemplate jdbcTemplate;

    public TravelAgentImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(TravelAgent entity) {

    }

    @Override
    public TravelAgent read(int id) {
        return null;
    }

    @Override
    public void update(TravelAgent entity) {

    }

    @Override
    public void delete(int id) {

    }
}
