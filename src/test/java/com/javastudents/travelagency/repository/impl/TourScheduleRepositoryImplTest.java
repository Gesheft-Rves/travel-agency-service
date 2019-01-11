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

        Assert.assertEquals(tourIdExpected, byId.getTourId());
        Assert.assertEquals(transportIdExpected, byId.getTransportId());
    }

    @Test
    @Override
    public void updateTest() {
        Timestamp timestampExpected = new Timestamp(System.currentTimeMillis());

        TourSchedule tourSchedule = tourScheduleRepository.read(1);

        tourSchedule.setStartingDateTime(timestampExpected);

        tourScheduleRepository.update(tourSchedule);

        Assert.assertEquals(timestampExpected, tourScheduleRepository.read(1).getStartingDateTime());
    }

    @Test
    @Override
    public void deleteTest() {
        tourScheduleRepository.delete(5);

        Assert.assertNull(tourScheduleRepository.read(5));
    }
}