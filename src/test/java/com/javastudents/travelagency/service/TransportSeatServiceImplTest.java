package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TransportSeat;
import com.javastudents.travelagency.service.impl.TransportSeatServiceImpl;
import com.javastudents.travelagency.service.impl.TransportServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransportSeatServiceImplTest {

    private final TransportSeatServiceImpl transportSeatServiceImpl;
    private final TransportServiceImpl transportServiceImpl;

    @Autowired
    public TransportSeatServiceImplTest(TransportSeatServiceImpl transportSeatServiceImpl,
                                        TransportServiceImpl transportServiceImpl) {
        this.transportSeatServiceImpl = transportSeatServiceImpl;
        this.transportServiceImpl = transportServiceImpl;
    }

    @Test
    public void list() {
        Integer expected = 3;
        Integer actual = transportSeatServiceImpl.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        TransportSeat transportSeat = transportSeatServiceImpl.getById(1);
        Integer actual = transportSeat.getId();
        Integer expected = 1;

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void save() {
        TransportSeat newTransportSeat = new TransportSeat(transportServiceImpl.getById(2),1,"рядом с водителем");
        transportSeatServiceImpl.save(newTransportSeat);

        Assert.assertNotNull(transportSeatServiceImpl.getById(4));
    }

    @Test
    public void delete() {
        TransportSeat newTransportSeat = new TransportSeat(transportServiceImpl.getById(2),3,"Zzz");
        transportSeatServiceImpl.save(newTransportSeat);

        Assert.assertNotNull(transportSeatServiceImpl.getById(4));

        transportSeatServiceImpl.delete(4);
        Assert.assertEquals(3, transportSeatServiceImpl.list().size());
    }
}