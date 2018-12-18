package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.Purchase;
import com.javastudents.travelagency.repository.PurchaseRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class PurchaseRepositoryImpl implements PurchaseRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PurchaseRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Purchase purchase) {
        @Language("MySQL")
        String query = "INSERT INTO purchase (tour_schedule_id, travel_agent_id, client_id, transport_id, transport_seat_id, operation_data) VALUES (?, ? , ?, ?, ?, ?)";

        jdbcTemplate.update(
                query,
                purchase.getTourScheduleId(),
                purchase.getTravelAgentId(),
                purchase.getClientId(),
                purchase.getTransportId(),
                purchase.getTransportSeatId(),
                purchase.getOperationData()
        );
    }

    @Override
    public Purchase read(int purchaseId) {
        return null;
    }

    @Override
    public void update(Purchase purchase) {
        @Language("MySQL")
        String query = "UPDATE purchase SET tour_schedule_id = ?, travel_agent_id = ?, client_id = ?, transport_id = ?, transport_seat_id = ?, operation_data = ? WHERE purchase_id = ?";

        jdbcTemplate.update(
                query,
                purchase.getTourScheduleId(),
                purchase.getTravelAgentId(),
                purchase.getClientId(),
                purchase.getTransportId(),
                purchase.getTransportSeatId(),
                purchase.getOperationData()
        );
    }

    @Override
    public void delete(int purchaseId) {
        @Language("MySQL")
        String query = "DELETE FROM purchase WHERE purchase_id = ?";

        jdbcTemplate.update(query, purchaseId);
    }
}
