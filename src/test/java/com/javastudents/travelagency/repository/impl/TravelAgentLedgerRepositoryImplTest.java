package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.TravelAgentLedger;
import com.javastudents.travelagency.repository.CrudTest;
import com.javastudents.travelagency.repository.TravelAgentLedgerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.*;

public class TravelAgentLedgerRepositoryImplTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TravelAgentLedgerRepository travelAgentLedgerRepository;

    @Test
    @Override
    public void createTest() {
    }

    @Test
    @Override
    public void readTest() {
        TravelAgentLedger byId = travelAgentLedgerRepository.read(1);
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
        TravelAgentLedger travelAgentLedger = travelAgentLedgerRepository.read(1);

        travelAgentLedgerRepository.delete(travelAgentLedger.getId());

        Assert.assertNull(travelAgentLedgerRepository.read(1));
    }
}