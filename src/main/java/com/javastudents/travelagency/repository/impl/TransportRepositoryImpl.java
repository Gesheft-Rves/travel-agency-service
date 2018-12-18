package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.Transport;
import com.javastudents.travelagency.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    }

    @Override
    public Transport read(int transportId) {
        return null;
    }

    @Override
    public void update(Transport transport) {

    }

    @Override
    public void delete(int transportId) {

    }
}
