package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.TourSchedule;
import com.javastudents.travelagency.repository.CrudTest;
import com.javastudents.travelagency.repository.TourScheduleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.*;

public class TourScheduleRepositoryImplTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TourScheduleRepository tourScheduleRepository;


    @Test
    @Override
    public void createTest() {
    }

    @Test
    @Override
    public void readTest() {
        TourSchedule byId = tourScheduleRepository.read(1);
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
        TourSchedule tourSchedule = tourScheduleRepository.read(1);

        tourScheduleRepository.delete(tourSchedule.getId());

        Assert.assertNull(tourScheduleRepository.read(1));
    }
}