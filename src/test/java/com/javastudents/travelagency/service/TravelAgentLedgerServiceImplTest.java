package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TravelAgentLedger;
import com.javastudents.travelagency.service.impl.PurchaseServiceImpl;
import com.javastudents.travelagency.service.impl.TravelAgentLedgerServiceImpl;
import com.javastudents.travelagency.service.impl.TravelAgentServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TravelAgentLedgerServiceImplTest {

    private final TravelAgentLedgerServiceImpl travelAgentLedgerServiceImpl;
    private final TravelAgentServiceImpl travelAgentServiceImpl;
    private final PurchaseServiceImpl purchaseServiceImpl;

    public TravelAgentLedgerServiceImplTest(TravelAgentLedgerServiceImpl travelAgentLedgerServiceImpl,
                                            TravelAgentServiceImpl travelAgentServiceImpl,
                                            PurchaseServiceImpl purchaseServiceImpl) {
        this.travelAgentLedgerServiceImpl = travelAgentLedgerServiceImpl;
        this.travelAgentServiceImpl = travelAgentServiceImpl;
        this.purchaseServiceImpl = purchaseServiceImpl;
    }

    @Test
    public void list() {
        Integer expected = 1;
        Integer actual = travelAgentLedgerServiceImpl.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        TravelAgentLedger travelAgentLedger = travelAgentLedgerServiceImpl.getById(1);
        Integer actual = travelAgentLedger.getId();
        Integer expected = 1;

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void save() {
        TravelAgentLedger newTravelAgentLedger = new TravelAgentLedger(travelAgentServiceImpl.getById(2),new Timestamp(new Date().getTime()), purchaseServiceImpl.getById(1),new BigDecimal(222));
        travelAgentLedgerServiceImpl.save(newTravelAgentLedger);

        Assert.assertNotNull(travelAgentLedgerServiceImpl.getById(2));
    }

    @Test
    public void delete() {
        TravelAgentLedger newTravelAgentLedger = new TravelAgentLedger(travelAgentServiceImpl.getById(2),new Timestamp(new Date().getTime()), purchaseServiceImpl.getById(1),new BigDecimal(222));
        travelAgentLedgerServiceImpl.save(newTravelAgentLedger);

        Assert.assertNotNull(travelAgentLedgerServiceImpl.getById(2));

        travelAgentLedgerServiceImpl.delete(2);
        Assert.assertEquals(1, travelAgentLedgerServiceImpl.list().size());
    }
}