package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.TravelAgentLedger;
import com.javastudents.travelagency.repository.TravelAgentLedgerRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TravelAgentLedgerRepositoryImpl implements TravelAgentLedgerRepository {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TravelAgentLedgerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void create(TravelAgentLedger travelAgentLedger) {
        @Language("MySQL")
        String query = "INSERT INTO travel_agent_ledger (travel_agent_id, operation_date, purchase_id, amount) VALUES (?, ?, ?)";

        jdbcTemplate.update(
                query,
                travelAgentLedger.getTravelAgentId(),
                travelAgentLedger.getOperationDate(),
                travelAgentLedger.getPurchaseId(),
                travelAgentLedger.getAmount()
        );
    }

    @Override
    public TravelAgentLedger read(int travelAgentLedgerId) {
        @Language("MySQL")
        String query = "SELECT * FROM transport_seat WHERE transport_seat_id=?";

        try {
            return jdbcTemplate.queryForObject(
                    query,
                    new Object[]{travelAgentLedgerId},

                    (rs, rowNum) -> TravelAgentLedger.builder()
                            .travelAgentId(rs.getInt("travel_agent_id"))
                            .operationDate(rs.getTimestamp("operation_date"))
                            .purchaseId(rs.getInt("purchase_id"))
                            .amount(rs.getBigDecimal("amount"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(TravelAgentLedger travelAgentLedger) {
        @Language("MySQL")
        String query = "UPDATE travel_agent_ledger SET travel_agent_id = ?, operation_date = ?, purchase_id = ?, amount = ? WHERE travel_agent_ledger_id = ?";

        jdbcTemplate.update(
                query,
                travelAgentLedger.getTravelAgentId(),
                travelAgentLedger.getOperationDate(),
                travelAgentLedger.getPurchaseId(),
                travelAgentLedger.getAmount(),
                travelAgentLedger.getId()
        );
    }

    @Override
    public void delete(int travelAgentLedgerId) {
        @Language("MySQL")
        String query = "DELETE FROM travel_agent_ledger WHERE travel_agent_ledger_id = ?";

        jdbcTemplate.update(query, travelAgentLedgerId);
    }
}
