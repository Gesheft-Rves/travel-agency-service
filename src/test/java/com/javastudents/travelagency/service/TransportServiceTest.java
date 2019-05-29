package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.Transport;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransportServiceTest {

    private final TransportService transportService;

    @Autowired
    public TransportServiceTest(TransportService transportService) {
        this.transportService = transportService;
    }

    @Test
    public void list() {
        Integer expected = 4;
        Integer actual = transportService.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        Transport transport = transportService.getById(1);
        Integer actual = transport.getId();
        Integer expected = 1;

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void save() {
        Transport newTransport = new Transport(5,"newTransport","newDescription",24);
        transportService.save(newTransport);

        Assert.assertNotNull(transportService.getById(5));
    }

    @Test
    public void delete() {
        Transport newTransport = new Transport(5,"newTransport","newDescription",24);
        transportService.save(newTransport);

        Assert.assertNotNull(transportService.getById(5));

        transportService.delete(5);
        Assert.assertEquals(4,transportService.list().size());
    }
}