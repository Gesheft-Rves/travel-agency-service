package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.TravelAgent;
import com.javastudents.travelagency.repository.CrudTest;
import com.javastudents.travelagency.repository.TravelAgentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.*;

public class TravelAgentRepositoryImplTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TravelAgentRepository travelAgentRepository;

    @Test
    @Override
    public void createTest() {
    }

    @Test
    @Override
    public void readTest() {
        TravelAgent byId = travelAgentRepository.read(1);
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
        TravelAgent travelAgent = travelAgentRepository.read(1);

        travelAgentRepository.delete(travelAgent.getId());

        Assert.assertNull(travelAgentRepository.read(1));
    }
}