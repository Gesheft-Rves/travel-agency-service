package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.*;
import com.javastudents.travelagency.entity.wrapper.PurchaseWrapper;
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
        String query = "SELECT * FROM purchase";

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

    @Override
    public List<PurchaseWrapper> listWrapper() {
        @Language("MySQL")
        String query = "SELECT * ," +
                "travel_agent.name as travel_agent_name, " +
                "client.name as client_name, " +
                "transport.name as transport_name " +
                "FROM purchase " +
                "JOIN tour_schedule ON purchase.tour_schedule_id = tour_schedule.tour_schedule_id " +
                "JOIN travel_agent ON purchase.travel_agent_id =  travel_agent.travel_agent_id " +
                "JOIN client ON purchase.client_id =  client.client_id " +
                "JOIN transport ON purchase.transport_id = transport.transport_id " +
                "JOIN transport_seat ON purchase.transport_seat_id = transport_seat.transport_seat_id";
        try {
            return jdbcTemplate.query(
                    query, new Object[]{},
                    (rs, rowNub) -> PurchaseWrapper.builder()
                            .purchaseId(rs.getInt("tour_id"))
                            .tourSchedule(TourSchedule.builder()
                                    .id(rs.getInt("tour_schedule_id"))
                                    .startingDateTime(rs.getTimestamp("starting_date_time"))
                                    .endingDateTime(rs.getTimestamp("ending_date_time"))
                                    .transportId(rs.getInt("transport_id"))
                                    .build()
                            )
                            .travelAgent(TravelAgent.builder()
                                    .id(rs.getInt("travel_agent_id"))
                                    .travelAgencyId(rs.getInt("travel_agent_id"))
                                    .name(rs.getString("travel_agent_name"))
                                    .surname(rs.getString("surname"))
                                    .patronymic(rs.getString("patronymic"))
                                    .enabled(rs.getBoolean("enabled"))
                                    .phoneNumber(rs.getString("phone_number"))
                                    .limitAmount(rs.getBigDecimal("limit_amount"))
                                    .build()
                            )
                            .client(Client.builder()
                                    .clientId(rs.getInt("client_id"))
                                    .documentTypeId(rs.getInt("document_type_id"))
                                    .documentSeriesNumber(rs.getString("document_series_number"))
                                    .name(rs.getString("client_name"))
                                    .surname(rs.getString("surname"))
                                    .patronymic(rs.getString("patronymic"))
                                    .address(rs.getString("address"))
                                    .phoneNumber(rs.getString("phone_number"))
                                    .build()
                            )
                            .transport(Transport.builder()
                                    .id(rs.getInt("transport_id"))
                                    .name(rs.getString("transport_name"))
                                    .description(rs.getString("description"))
                                    .passengerSeatQty(rs.getInt("passenger_seat_qty"))
                                    .build()
                            )
                            .transportSeat(TransportSeat.builder()
                                    .id(rs.getInt("transport_seat_id"))
                                    .transportId(rs.getInt("transport_id"))
                                    .seatNo(rs.getInt("seat_no"))
                                    .comment(rs.getString("comment"))
                                    .build()
                            )
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public PurchaseWrapper readWrapper(int purchaseId) {
        @Language("MySQL")
        String query = "SELECT * " +
                "FROM purchase " +
                "JOIN tour_schedule ON purchase.tour_schedule_id = tour_schedule.tour_schedule_id " +
                "JOIN travel_agent ON purchase.travel_agent_id =  travel_agent.travel_agent_id " +
                "JOIN client ON purchase.client_id =  client.client_id " +
                "JOIN transport ON purchase.transport_id = transport.transport_id " +
                "JOIN transport_seat ON purchase.transport_seat_id = transport_seat.transport_seat_id " +
                "WHERE purchase.purchase_id=?";
      try{
            return jdbcTemplate.queryForObject(
                    query, new Object[] {purchaseId},
                    (rs, rowNub) -> PurchaseWrapper.builder()
                            .purchaseId(rs.getInt("tour_id"))
                            .tourSchedule(TourSchedule.builder()
                                    .id(rs.getInt("tour_schedule_id"))
                                    .startingDateTime(rs.getTimestamp("starting_date_time"))
                                    .endingDateTime(rs.getTimestamp("ending_date_time"))
                                    .transportId(rs.getInt("transport_id"))
                                    .build()
                            )
                            .travelAgent(TravelAgent.builder()
                                    .id(rs.getInt("travel_agent_id"))
                                    .travelAgencyId(rs.getInt("travel_agent_id"))
                                    .name(rs.getString("name"))
                                    .surname(rs.getString("surname"))
                                    .patronymic(rs.getString("patronymic"))
                                    .enabled(rs.getBoolean("enabled"))
                                    .phoneNumber(rs.getString("phone_number"))
                                    .limitAmount(rs.getBigDecimal("limit_amount"))
                                    .build()
                            )
                            .client(Client.builder()
                                    .clientId(rs.getInt("client_id"))
                                    .documentTypeId(rs.getInt("document_type_id"))
                                    .documentSeriesNumber(rs.getString("document_series_number"))
                                    .name(rs.getString("name"))
                                    .surname(rs.getString("surname"))
                                    .patronymic(rs.getString("patronymic"))
                                    .address(rs.getString("address"))
                                    .phoneNumber(rs.getString("phone_number"))
                                    .build()
                            )
                            .transport(Transport.builder()
                                    .id(rs.getInt("transport_id"))
                                    .name(rs.getString("name"))
                                    .description(rs.getString("description"))
                                    .passengerSeatQty(rs.getInt("passenger_seat_qty"))
                                    .build()
                            )
                            .transportSeat(TransportSeat.builder()
                                    .id(rs.getInt("transport_seat_id"))
                                    .transportId(rs.getInt("transport_id"))
                                    .seatNo(rs.getInt("seat_no"))
                                    .comment(rs.getString("comment"))
                                    .build()
                            )
                            .build()
            );
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public void updateWrapper(PurchaseWrapper purchaseWrapper){

    }
}
