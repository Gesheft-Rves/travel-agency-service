package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.Transport;
import com.javastudents.travelagency.service.impl.TransportServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransportServiceImplTest {

    private final TransportServiceImpl transportServiceImpl;

    @Autowired
    public TransportServiceImplTest(TransportServiceImpl transportServiceImpl) {
        this.transportServiceImpl = transportServiceImpl;
    }

    @Test
    public void list() {
        Integer expected = 4;
        Integer actual = transportServiceImpl.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        Transport transport = transportServiceImpl.getById(1);
        Integer actual = transport.getId();
        Integer expected = 1;

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void save() {
        Transport newTransport = new Transport(5,"newTransport","newDescription",24);
        transportServiceImpl.save(newTransport);

        Assert.assertNotNull(transportServiceImpl.getById(5));
    }

    @Test
    public void delete() {
        Transport newTransport = new Transport(5,"newTransport","newDescription",24);
        transportServiceImpl.save(newTransport);

        Assert.assertNotNull(transportServiceImpl.getById(5));

        transportServiceImpl.delete(5);
        Assert.assertEquals(4, transportServiceImpl.list().size());
    }
}