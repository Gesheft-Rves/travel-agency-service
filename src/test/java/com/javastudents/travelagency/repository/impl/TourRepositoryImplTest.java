package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.Tour;
import com.javastudents.travelagency.repository.CrudTest;
import com.javastudents.travelagency.repository.TourRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.*;

public class TourRepositoryImplTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Autowired
    private TourRepository tourRepository;

    @Test
    @Override
    public void createTest() {
    }

    @Test
    @Override
    public void readTest() {
        Tour byId = tourRepository.read(1);
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
    }
}