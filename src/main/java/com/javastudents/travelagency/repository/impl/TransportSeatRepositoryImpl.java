package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.TransportSeat;
import com.javastudents.travelagency.repository.TransportSeatRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TransportSeatRepositoryImpl implements TransportSeatRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TransportSeatRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(TransportSeat transportSeat) {
        @Language("MySQL")
        String query = "INSERT INTO transport_seat (transport_id, seat_no, comment) VALUES (?,?,?)";

        jdbcTemplate.update(
                query,
                transportSeat.getTransportId(),
                transportSeat.getSeatNo(),
                transportSeat.getComment()
        );
    }

    @Override
    public TransportSeat read(int transportSeatId) {
        @Language("MySQL")
        String query = "SELECT * FROM transport_seat WHERE transport_seat_id=?";

        try {
            return jdbcTemplate.queryForObject(
                    query,
                    new Object[]{transportSeatId},

                    (rs, rowNum) -> TransportSeat.builder()
                            .id(rs.getInt("transport_seat_id"))
                            .transportId(rs.getInt("transport_id"))
                            .seatNo(rs.getInt("seat_no"))
                            .comment(rs.getString("comment"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    @Override
    public void update(TransportSeat transportSeat) {
        @Language("MySQL")
        String query = "UPDATE transport_seat SET transport_id = ?, seat_no = ?, comment = ? WHERE transport_seat_id = ?";

        jdbcTemplate.update(
                query,
                transportSeat.getTransportId(),
                transportSeat.getSeatNo(),
                transportSeat.getComment(),
                transportSeat.getId()
        );
    }

    @Override
    public void delete(int transportSeatId) {
        @Language("MySQL")
        String query = "DELETE FROM transport_seat WHERE transport_seat_id = ?";

        jdbcTemplate.update(query, transportSeatId);
    }
}
