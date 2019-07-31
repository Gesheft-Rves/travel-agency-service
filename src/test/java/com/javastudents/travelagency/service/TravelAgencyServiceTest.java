package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TravelAgency;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TravelAgencyServiceTest {

    private final TravelAgencyService travelAgencyService;

    @Autowired
    public TravelAgencyServiceTest(TravelAgencyService travelAgencyService) {
        this.travelAgencyService = travelAgencyService;
    }

    @Test
    public void list() {
        Integer expected = 6;
        Integer actual = travelAgencyService.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        TravelAgency travelAgency = travelAgencyService.getById(1);
        Integer actual = travelAgency.getId();
        Integer expected = 1;

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void save() {
        TravelAgency newTravelAgency = new TravelAgency(7,"Zqs","WWW","2222","WWEqAd","@mail");
        travelAgencyService.save(newTravelAgency);

        Assert.assertNotNull(travelAgencyService.getById(3));
    }

    @Test
    public void delete() {
        TravelAgency newTravelAgency = new TravelAgency(7,"Zqs","WWW","2222","WWEqAd","@mail");
        travelAgencyService.save(newTravelAgency);

        Assert.assertNotNull(travelAgencyService.getById(7));

        travelAgencyService.delete(7);
        Assert.assertEquals(6,travelAgencyService.list().size());
    }
}