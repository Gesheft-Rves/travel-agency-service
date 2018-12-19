package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.Transport;
import com.javastudents.travelagency.repository.CrudRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TransportRepositoryImpl implements CrudRepository<Transport> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TransportRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Transport transport) {
        @Language("MySQL")
        String query = "INSERT INTO transport (name, description, passenger_seat_qty) VALUES (?,?,?)";

        jdbcTemplate.update(
                query,
                transport.getName(),
                transport.getDescription(),
                transport.getPassengerSeatQty()
        );
    }

    @Override
    public Transport read(int transportId) {
        @Language("MySQL")
        String query = "SELECT * FROM transport WHERE transport_id=?";

        try {
            return jdbcTemplate.queryForObject(
                    query,
                    new Object[]{transportId},

                    (rs, rowNum) -> Transport.builder()
                            .name(rs.getString("name"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(Transport transport) {
        @Language("MySQL")
        String query = "UPDATE transport SET name = ?, description = ?, passenger_seat_qty = ? WHERE tour_category_id = ?";

        jdbcTemplate.update(query, transport.getName(), transport.getDescription(), transport.getPassengerSeatQty(), transport.getId());
    }

    @Override
    public void delete(int transportId) {
        @Language("MySQL")
        String query = "DELETE FROM transport WHERE transport_id = ?";

        jdbcTemplate.update(query, transportId);
    }
}
