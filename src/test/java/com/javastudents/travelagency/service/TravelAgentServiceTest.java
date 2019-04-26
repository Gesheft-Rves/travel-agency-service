package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TravelAgent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TravelAgentServiceTest {

    @Autowired
    private TravelAgentService travelAgentService;

    @Autowired
    private TravelAgencyService travelAgencyService;

    @Test
    public void list() {
        Integer expected = 7;
        Integer actual = travelAgentService.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        TravelAgent travelAgent = travelAgentService.getById(1);
        Integer actual = travelAgent.getId();
        Integer expected = 1;

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void save() {
        TravelAgent newTravelAgent = new TravelAgent(travelAgencyService.getById(3),"w","w","w",false,"w",new BigDecimal(12222));
        travelAgentService.save(newTravelAgent);

        Assert.assertNotNull(travelAgentService.getById(8));
    }

    @Test
    public void delete() {
        TravelAgent newTravelAgent = new TravelAgent(travelAgencyService.getById(3),"w","w","w",false,"w",new BigDecimal(12222));
        travelAgentService.save(newTravelAgent);

        Assert.assertNotNull(travelAgentService.getById(8));

        travelAgentService.delete(8);
        Assert.assertEquals(7,travelAgentService.list().size());
    }
}