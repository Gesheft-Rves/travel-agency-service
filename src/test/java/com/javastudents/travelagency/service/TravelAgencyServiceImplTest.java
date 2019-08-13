package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TravelAgency;
import com.javastudents.travelagency.service.impl.TravelAgencyServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TravelAgencyServiceImplTest {

    private final TravelAgencyServiceImpl travelAgencyServiceImpl;

    @Autowired
    public TravelAgencyServiceImplTest(TravelAgencyServiceImpl travelAgencyServiceImpl) {
        this.travelAgencyServiceImpl = travelAgencyServiceImpl;
    }

    @Test
    public void list() {
        Integer expected = 6;
        Integer actual = travelAgencyServiceImpl.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        TravelAgency travelAgency = travelAgencyServiceImpl.getById(1);
        Integer actual = travelAgency.getId();
        Integer expected = 1;

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void save() {
        TravelAgency newTravelAgency = new TravelAgency(7,"Zqs","WWW","2222","WWEqAd","@mail");
        travelAgencyServiceImpl.save(newTravelAgency);

        Assert.assertNotNull(travelAgencyServiceImpl.getById(3));
    }

    @Test
    public void delete() {
        TravelAgency newTravelAgency = new TravelAgency(7,"Zqs","WWW","2222","WWEqAd","@mail");
        travelAgencyServiceImpl.save(newTravelAgency);

        Assert.assertNotNull(travelAgencyServiceImpl.getById(7));

        travelAgencyServiceImpl.delete(7);
        Assert.assertEquals(6, travelAgencyServiceImpl.list().size());
    }
}