package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TravelAgent;
import com.javastudents.travelagency.service.impl.TravelAgencyServiceImpl;
import com.javastudents.travelagency.service.impl.TravelAgentServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TravelAgentServiceImplTest {

    private final TravelAgentServiceImpl travelAgentServiceImpl;
    private final TravelAgencyServiceImpl travelAgencyServiceImpl;

    @Autowired
    public TravelAgentServiceImplTest(TravelAgentServiceImpl travelAgentServiceImpl,
                                      TravelAgencyServiceImpl travelAgencyServiceImpl) {
        this.travelAgentServiceImpl = travelAgentServiceImpl;
        this.travelAgencyServiceImpl = travelAgencyServiceImpl;
    }

    @Test
    public void list() {
        Integer expected = 7;
        Integer actual = travelAgentServiceImpl.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        TravelAgent travelAgent = travelAgentServiceImpl.getById(1);
        Integer actual = travelAgent.getId();
        Integer expected = 1;

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void save() {
        TravelAgent newTravelAgent = new TravelAgent(travelAgencyServiceImpl.getById(3),"w","w","w",false,"w",new BigDecimal(12222));
        travelAgentServiceImpl.save(newTravelAgent);

        Assert.assertNotNull(travelAgentServiceImpl.getById(8));
    }

    @Test
    public void delete() {
        TravelAgent newTravelAgent = new TravelAgent(travelAgencyServiceImpl.getById(3),"w","w","w",false,"w",new BigDecimal(12222));
        travelAgentServiceImpl.save(newTravelAgent);

        Assert.assertNotNull(travelAgentServiceImpl.getById(8));

        travelAgentServiceImpl.delete(8);
        Assert.assertEquals(7, travelAgentServiceImpl.list().size());
    }
}