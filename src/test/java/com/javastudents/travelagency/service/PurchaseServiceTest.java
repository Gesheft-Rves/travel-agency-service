package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.Purchase;
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
public class PurchaseServiceTest {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private TourScheduleService tourScheduleService;

    @Autowired
    private TravelAgentService travelAgentService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private TransportService transportService;

    @Autowired
    private TransportSeatService transportSeatService;

    @Test
    public void list() {
        Integer expected = 1;
        Integer actual = purchaseService.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        Purchase purchase = purchaseService.getById(1);
        Integer actual = purchase.getId();
        Integer expected = 1;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void save() {
        Purchase newPurchase = new Purchase(tourScheduleService.getById(2),travelAgentService.getById(2),clientService.getById(2),transportService.getById(2),transportSeatService.getById(2),new Timestamp(new Date().getTime()));
        purchaseService.save(newPurchase);

        Assert.assertNotNull(purchaseService.getById(2));
    }

    @Test
    public void delete() {
        Purchase newPurchase = new Purchase(tourScheduleService.getById(2),travelAgentService.getById(2),clientService.getById(2),transportService.getById(2),transportSeatService.getById(2),new Timestamp(new Date().getTime()));
        purchaseService.save(newPurchase);

        Assert.assertNotNull(purchaseService.getById(2));

        purchaseService.delete(2);
        Assert.assertEquals(1,purchaseService.list().size());
    }
}