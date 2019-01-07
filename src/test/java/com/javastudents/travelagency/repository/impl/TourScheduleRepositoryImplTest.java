package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.TourSchedule;
import com.javastudents.travelagency.repository.CrudTest;
import com.javastudents.travelagency.repository.TourScheduleRepository;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;

import static org.junit.Assert.*;

public class TourScheduleRepositoryImplTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TourScheduleRepository tourScheduleRepository;


    @Test
    @Override
    public void createTest() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        TourSchedule tourSchedule = TourSchedule.builder()
                .tourId(1)
                .startingDateTime(timestamp)
                .endingDateTime(new Timestamp(System.currentTimeMillis()))
                .transportId(1)
                .build();
        tourScheduleRepository.create(tourSchedule);

        @Language("MySQL")
        String sql = "SELECT starting_date_time from tour_schedule where tour_schedule_id = (select max(tour_schedule_id) from tour_schedule)";
        Timestamp startingDateTimeTest = jdbcTemplate.queryForObject(sql, Timestamp.class);

        Assert.assertEquals(timestamp, startingDateTimeTest);
    }

    @Test
    @Override
    public void readTest() {
        Integer tourIdExpected = 1;
        Integer transportIdExpected = 1;

        TourSchedule byId = tourScheduleRepository.read(1);

        Assert.assertNotNull(byId);
        Assert.assertEquals(tourIdExpected, byId.getTourId());
        Assert.assertEquals(transportIdExpected, byId.getTransportId());
    }

    @Test
    @Override
    public void updateTest() {
        TourSchedule tourSchedule = tourScheduleRepository.read(1);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        tourSchedule.setStartingDateTime(timestamp);

        tourScheduleRepository.update(tourSchedule);

        Assert.assertEquals(timestamp, tourSchedule.getStartingDateTime());
    }

    @Test
    @Override
    public void deleteTest() {
        TourSchedule tourScheduleNew = TourSchedule.builder()
                .tourId(1)
                .startingDateTime(new Timestamp(System.currentTimeMillis()))
                .endingDateTime(new Timestamp(System.currentTimeMillis()))
                .transportId(1)
                .build();
        tourScheduleRepository.create(tourScheduleNew);

        @Language("MySQL")
        String sql = "select max(tour_schedule_id) from tour_schedule";
        int id = jdbcTemplate.queryForObject(sql, int.class);

        TourSchedule tourSchedule = tourScheduleRepository.read(id);

        Assert.assertNotNull(tourSchedule);

        tourScheduleRepository.delete(id);

        Assert.assertNull(tourScheduleRepository.read(id));
    }
}