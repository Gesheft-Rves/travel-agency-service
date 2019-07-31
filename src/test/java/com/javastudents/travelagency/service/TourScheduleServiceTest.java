package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TourSchedule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TourScheduleServiceTest {

    private final TourScheduleService tourScheduleService;
    private final TourService tourService;
    private final TransportService transportService;

    @Autowired
    public TourScheduleServiceTest(TourScheduleService tourScheduleService,
                                   TourService tourService,
                                   TransportService transportService) {
        this.tourScheduleService = tourScheduleService;
        this.tourService = tourService;
        this.transportService = transportService;
    }

    @Test
    public void list() {
        Integer expected = 2;
        Integer actual = tourScheduleService.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        TourSchedule tourSchedule = tourScheduleService.getById(1);
        Integer actual = tourSchedule.getId();
        Integer expected = 1;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void save() {
        LocalDateTime date = LocalDateTime.now();
        TourSchedule newTourSchedule = new TourSchedule(tourService.getById(1),date,date, transportService.getById(2));
        tourScheduleService.save(newTourSchedule);

        Assert.assertNotNull(tourScheduleService.getById(2));
    }

    @Test
    public void delete() {
        LocalDateTime date = LocalDateTime.now();
        TourSchedule newTourSchedule = new TourSchedule(tourService.getById(1),date,date, transportService.getById(2));
        tourScheduleService.save(newTourSchedule);

        Assert.assertNotNull(tourScheduleService.getById(2));

        tourScheduleService.delete(3);
        Assert.assertEquals(2,tourScheduleService.list().size());
    }
}