package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TravelAgentLedger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TravelAgentLedgerServiceTest {

    private final TravelAgentLedgerService travelAgentLedgerService;
    private final TravelAgentService travelAgentService;
    private final PurchaseService purchaseService;

    public TravelAgentLedgerServiceTest(TravelAgentLedgerService travelAgentLedgerService,
                                        TravelAgentService travelAgentService,
                                        PurchaseService purchaseService) {
        this.travelAgentLedgerService = travelAgentLedgerService;
        this.travelAgentService = travelAgentService;
        this.purchaseService = purchaseService;
    }

    @Test
    public void list() {
        Integer expected = 1;
        Integer actual = travelAgentLedgerService.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        TravelAgentLedger travelAgentLedger = travelAgentLedgerService.getById(1);
        Integer actual = travelAgentLedger.getId();
        Integer expected = 1;

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void save() {
        TravelAgentLedger newTravelAgentLedger = new TravelAgentLedger(travelAgentService.getById(2),new Timestamp(new Date().getTime()),purchaseService.getById(1),new BigDecimal(222));
        travelAgentLedgerService.save(newTravelAgentLedger);

        Assert.assertNotNull(travelAgentLedgerService.getById(2));
    }

    @Test
    public void delete() {
        TravelAgentLedger newTravelAgentLedger = new TravelAgentLedger(travelAgentService.getById(2),new Timestamp(new Date().getTime()),purchaseService.getById(1),new BigDecimal(222));
        travelAgentLedgerService.save(newTravelAgentLedger);

        Assert.assertNotNull(travelAgentLedgerService.getById(2));

        travelAgentLedgerService.delete(2);
        Assert.assertEquals(1,travelAgentLedgerService.list().size());
    }
}