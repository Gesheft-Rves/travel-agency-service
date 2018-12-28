package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.TravelAgent;
import com.javastudents.travelagency.repository.TravelAgentRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TravelAgentRepositoryImpl implements TravelAgentRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TravelAgentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(TravelAgent travelAgent) {
        @Language("MySQL")
        String query = "INSERT INTO travel_agent (travel_agency_id, name, surname, patronymic, enabled, phone_number, limit_amount) VALUES (?,?,?,?,?,?,?)";

        jdbcTemplate.update(
                query,
                travelAgent.getTravelAgencyId(),
                travelAgent.getName(),
                travelAgent.getSurname(),
                travelAgent.getPatronymic(),
                travelAgent.isEnabled(),
                travelAgent.getPhoneNumber(),
                travelAgent.getLimitAmount()
        );
    }

    @Override
    public TravelAgent read(int travelAgentId) {
        @Language("MySQL")
        String query = "SELECT * FROM travel_agent WHERE travel_agent_id=?";

        try {
            return jdbcTemplate.queryForObject(
                    query,
                    new Object[]{travelAgentId},

                    (rs, rowNum) -> TravelAgent.builder()
                            .travelAgencyId(rs.getInt("travel_agency_id"))
                            .name(rs.getString("name"))
                            .surname(rs.getString("surname"))
                            .patronymic(rs.getString("patronymic"))
                            .enabled(rs.getBoolean("enabled"))
                            .phoneNumber(rs.getString("phone_number"))
                            .limitAmount(rs.getBigDecimal("limitAmount"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(TravelAgent travelAgent) {
        @Language("MySQL")
        String query = "UPDATE travel_agent SET travel_agency_id = ?, name = ?, surname = ?, patronymic = ?, enabled = ?, phone_number = ?, limit_amount = ? WHERE travel_agent_id = ?";

        jdbcTemplate.update(
                query,
                travelAgent.getTravelAgencyId(),
                travelAgent.getName(),
                travelAgent.getSurname(),
                travelAgent.getPatronymic(),
                travelAgent.isEnabled(),
                travelAgent.getPhoneNumber(),
                travelAgent.getLimitAmount(),
                travelAgent.getId()
        );
    }

    @Override
    public void delete(int travelAgentId) {
        @Language("MySQL")
        String query = "DELETE FROM travel_agent WHERE travel_agent_id = ?";

        jdbcTemplate.update(query, travelAgentId);
    }
}
