package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.Purchase;
import com.javastudents.travelagency.repository.PurchaseRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepositoryImpl implements PurchaseRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PurchaseRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Purchase purchase) {
        @Language("MySQL")
        String query = "INSERT INTO purchase (tour_schedule_id, travel_agent_id, client_id, transport_id, transport_seat_id, operation_date) VALUES (?, ? , ?, ?, ?, ?)";

        jdbcTemplate.update(
                query,
                purchase.getTourScheduleId(),
                purchase.getTravelAgentId(),
                purchase.getClientId(),
                purchase.getTransportId(),
                purchase.getTransportSeatId(),
                purchase.getOperationDate()
        );
    }

    @Override
    public Purchase read(int purchaseId) {
        @Language("MySQL")
        String query = "SELECT * FROM purchase WHERE purchase_id=?";

        try {
            return jdbcTemplate.queryForObject(
                    query,
                    new Object[]{purchaseId},

                    (rs, rowNum) -> Purchase.builder()
                            .purchaseId(rs.getInt("purchase_id"))
                            .tourScheduleId(rs.getInt("tour_schedule_id"))
                            .travelAgentId(rs.getInt("travel_agent_id"))
                            .clientId(rs.getInt("client_id"))
                            .transportId(rs.getInt("transport_id"))
                            .transportSeatId(rs.getInt("transport_seat_id"))
                            .operationDate(rs.getTimestamp("operation_date"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(Purchase purchase) {
        @Language("MySQL")
        String query = "UPDATE purchase SET tour_schedule_id = ?, travel_agent_id = ?, client_id = ?, transport_id = ?, transport_seat_id = ?, operation_date = ? WHERE purchase_id = ?";

        jdbcTemplate.update(
                query,
                purchase.getTourScheduleId(),
                purchase.getTravelAgentId(),
                purchase.getClientId(),
                purchase.getTransportId(),
                purchase.getTransportSeatId(),
                purchase.getOperationDate(),
                purchase.getPurchaseId()
        );
    }

    @Override
    public void delete(int purchaseId) {
        @Language("MySQL")
        String query = "DELETE FROM purchase WHERE purchase_id = ?";

        jdbcTemplate.update(query, purchaseId);
    }

    @Override
    public List<Purchase> list() {
        @Language("MySQL")
        String query = "SELECT * FROM app_permission";

        try {
            return jdbcTemplate.query(
                    query, new Object[]{},
                    (rs, rowNum) -> Purchase.builder()
                            .purchaseId(rs.getInt("purchase_id"))
                            .tourScheduleId(rs.getInt("tour_schedule_id"))
                            .travelAgentId(rs.getInt("travel_agent_id"))
                            .clientId(rs.getInt("client_id"))
                            .transportId(rs.getInt("transport_id"))
                            .transportSeatId(rs.getInt("transport_seat_id"))
                            .operationDate(rs.getTimestamp("operation_date"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
