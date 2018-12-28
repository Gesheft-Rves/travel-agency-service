package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.TransportSeat;
import com.javastudents.travelagency.repository.CrudTest;
import com.javastudents.travelagency.repository.TransportSeatRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.*;

public class TransportSeatRepositoryImplTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TransportSeatRepository transportSeatRepository;

    @Test
    @Override
    public void createTest() {
    }

    @Test
    @Override
    public void readTest() {
        TransportSeat byId = transportSeatRepository.read(1);
        Assert.assertNotNull(byId);
        Assert.assertEquals(1, byId);
    }

    @Test
    @Override
    public void updateTest() {
    }

    @Test
    @Override
    public void deleteTest() {
        TransportSeat transportSeat = transportSeatRepository.read(1);

        transportSeatRepository.delete(transportSeat.getId());

        Assert.assertNull(transportSeatRepository.read(1));
    }
}