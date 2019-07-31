package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TransportSeat;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransportSeatServiceTest {

    private final TransportSeatService transportSeatService;
    private final TransportService transportService;

    @Autowired
    public TransportSeatServiceTest(TransportSeatService transportSeatService,
                                    TransportService transportService) {
        this.transportSeatService = transportSeatService;
        this.transportService = transportService;
    }

    @Test
    public void list() {
        Integer expected = 3;
        Integer actual = transportSeatService.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        TransportSeat transportSeat = transportSeatService.getById(1);
        Integer actual = transportSeat.getId();
        Integer expected = 1;

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void save() {
        TransportSeat newTransportSeat = new TransportSeat(transportService.getById(2),1,"рядом с водителем");
        transportSeatService.save(newTransportSeat);

        Assert.assertNotNull(transportSeatService.getById(4));
    }

    @Test
    public void delete() {
        TransportSeat newTransportSeat = new TransportSeat(transportService.getById(2),3,"Zzz");
        transportSeatService.save(newTransportSeat);

        Assert.assertNotNull(transportSeatService.getById(4));

        transportSeatService.delete(4);
        Assert.assertEquals(3,transportSeatService.list().size());
    }
}