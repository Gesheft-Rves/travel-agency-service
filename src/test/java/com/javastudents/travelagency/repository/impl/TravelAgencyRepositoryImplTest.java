package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.TravelAgency;
import com.javastudents.travelagency.repository.CrudTest;
import com.javastudents.travelagency.repository.TravelAgencyRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.*;

public class TravelAgencyRepositoryImplTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TravelAgencyRepository travelAgencyRepository;

    @Test
    @Override
    public void createTest() {
    }

    @Test
    @Override
    public void readTest() {
        TravelAgency byId = travelAgencyRepository.read(1);
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
        TravelAgency travelAgency = travelAgencyRepository.read(1);

        travelAgencyRepository.delete(travelAgency.getId());

        Assert.assertNull(travelAgencyRepository.read(1));
    }
}