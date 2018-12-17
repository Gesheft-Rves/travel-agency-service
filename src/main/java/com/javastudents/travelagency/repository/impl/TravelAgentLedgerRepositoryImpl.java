package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.TravelAgentLedger;
import com.javastudents.travelagency.repository.TravelAgentLedgerRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TravelAgentLedgerRepositoryImpl implements TravelAgentLedgerRepository {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TravelAgentLedgerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void create(TravelAgentLedger travelAgentLedger) {
        @Language("MySQL")
        String query = "INSERT INTO travel_agent_ledger (travel_agent_id, operatin_date, purchase_id, amount) VALUES (?)";

        jdbcTemplate.update(query);
    }

    @Override
    public TravelAgentLedger read(int travelAgentLedgerId) {
        return null;
    }

    @Override
    public void update(TravelAgentLedger travelAgentLedger) {

    }

    @Override
    public void delete(int travelAgentLedgerId) {

    }
}
