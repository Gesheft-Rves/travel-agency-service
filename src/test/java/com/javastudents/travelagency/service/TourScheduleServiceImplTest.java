package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TourSchedule;
import com.javastudents.travelagency.service.impl.TourScheduleServiceImpl;
import com.javastudents.travelagency.service.impl.TourServiceImpl;
import com.javastudents.travelagency.service.impl.TransportServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TourScheduleServiceImplTest {

    private final TourScheduleServiceImpl tourScheduleServiceImpl;
    private final TourServiceImpl tourServiceImpl;
    private final TransportServiceImpl transportServiceImpl;

    @Autowired
    public TourScheduleServiceImplTest(TourScheduleServiceImpl tourScheduleServiceImpl,
                                       TourServiceImpl tourServiceImpl,
                                       TransportServiceImpl transportServiceImpl) {
        this.tourScheduleServiceImpl = tourScheduleServiceImpl;
        this.tourServiceImpl = tourServiceImpl;
        this.transportServiceImpl = transportServiceImpl;
    }

    @Test
    public void list() {
        Integer expected = 2;
        Integer actual = tourScheduleServiceImpl.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        TourSchedule tourSchedule = tourScheduleServiceImpl.getById(1);
        Integer actual = tourSchedule.getId();
        Integer expected = 1;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void save() {
        LocalDateTime date = LocalDateTime.now();
        TourSchedule newTourSchedule = new TourSchedule(tourServiceImpl.getById(1),date,date, transportServiceImpl.getById(2));
        tourScheduleServiceImpl.save(newTourSchedule);

        Assert.assertNotNull(tourScheduleServiceImpl.getById(2));
    }

    @Test
    public void delete() {
        LocalDateTime date = LocalDateTime.now();
        TourSchedule newTourSchedule = new TourSchedule(tourServiceImpl.getById(1),date,date, transportServiceImpl.getById(2));
        tourScheduleServiceImpl.save(newTourSchedule);

        Assert.assertNotNull(tourScheduleServiceImpl.getById(2));

        tourScheduleServiceImpl.delete(3);
        Assert.assertEquals(2, tourScheduleServiceImpl.list().size());
    }
}