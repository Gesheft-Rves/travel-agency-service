package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.Transport;
import com.javastudents.travelagency.repository.CrudTest;
import com.javastudents.travelagency.repository.TransportRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.*;

public class TransportRepositoryImplTest extends AbstractTest implements CrudTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TransportRepository transportRepository;


    @Test
    @Override
    public void createTest() {
    }

    @Test
    @Override
    public void readTest() {
        Transport byId = transportRepository.read(1);
        Assert.assertNotNull(byId);
        Assert.assertEquals(byId, byId);
    }

    @Test
    @Override
    public void updateTest() {
    }

    @Test
    @Override
    public void deleteTest() {
        Transport transport = transportRepository.read(1);

        transportRepository.delete(transport.getId());

        Assert.assertNull(transportRepository.read(1));
    }
}