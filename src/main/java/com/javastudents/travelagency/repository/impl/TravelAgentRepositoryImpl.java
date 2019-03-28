package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.TravelAgency;
import com.javastudents.travelagency.entity.TravelAgent;
import com.javastudents.travelagency.repository.TravelAgentRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TravelAgentRepositoryImpl implements TravelAgentRepository {

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
                travelAgent.getTravelAgency(),
                travelAgent.getName(),
                travelAgent.getSurname(),
                travelAgent.getPatronymic(),
                travelAgent.getEnabled(),
                travelAgent.getPhoneNumber(),
                travelAgent.getLimitAmount()
        );
    }

    @Override
    public TravelAgent read(int travelAgentId) {

        @Language("MySQL")
        String query = "SELECT *, " +
                "travel_agent.phone_number as travel_agent_phone_number, " +
                "travel_agency.phone_number as travel_agency_phone_number " +
                "FROM travel_agent " +
                "JOIN travel_agency on travel_agent.travel_agency_id = travel_agency.travel_agency_id "+
                "WHERE travel_agent_id=?";

        try {
            return jdbcTemplate.queryForObject(
                    query,
                    new Object[]{travelAgentId},

                    (rs, rowNum) -> TravelAgent.builder()
                            .id(rs.getInt("travel_agent_id"))
                            .travelAgency(TravelAgency.builder()
                                    .id(rs.getInt("travel_agency_id"))
                                    .abbreviatedName(rs.getString("abbreviated_name"))
                                    .phoneNumber(rs.getString("phone_number"))
                                    .site(rs.getString("site"))
                                    .emailAddress(rs.getString("email_address"))
                                    .build())
                            .name(rs.getString("name"))
                            .surname(rs.getString("surname"))
                            .patronymic(rs.getString("patronymic"))
                            .enabled(rs.getBoolean("enabled"))
                            .phoneNumber(rs.getString("phone_number"))
                            .limitAmount(rs.getBigDecimal("limit_amount"))
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
                travelAgent.getTravelAgency().getId(),
                travelAgent.getName(),
                travelAgent.getSurname(),
                travelAgent.getPatronymic(),
                travelAgent.getEnabled(),
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

    @Override
    public List<TravelAgent> list() {
        return null;
    }
}
