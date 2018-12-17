package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.TravelAgent;
import com.javastudents.travelagency.repository.TravelAgentRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TravelAgentRepositoryImpl implements TravelAgentRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TravelAgentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(TravelAgent travelAgent) {
        @Language("MySQL")
        String query = "INSERT INTO travel_agent (travel_agency_id, name, surname, patronymic, enabled, phone_number, limit_amount) VALUES (?)";

        jdbcTemplate.update(query, travelAgent.getName());
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
