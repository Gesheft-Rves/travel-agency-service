package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TourSchedule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TourScheduleServiceTest {

    @Autowired
    private TourScheduleService tourScheduleService;

    @Autowired
    private TourService tourService;

    @Autowired
    private TransportService transportService;

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
        TourSchedule newTourSchedule = new TourSchedule(tourService.getById(1),new Timestamp(new Date().getTime()),new Timestamp(new Date().getTime()), transportService.getById(2));
        tourScheduleService.save(newTourSchedule);

        Assert.assertNotNull(tourScheduleService.getById(2));
    }

    @Test
    public void delete() {
        TourSchedule newTourSchedule = new TourSchedule(tourService.getById(1),new Timestamp(new Date().getTime()),new Timestamp(new Date().getTime()), transportService.getById(2));
        tourScheduleService.save(newTourSchedule);

        Assert.assertNotNull(tourScheduleService.getById(2));

        tourScheduleService.delete(3);
        Assert.assertEquals(2,tourScheduleService.list().size());
    }
}