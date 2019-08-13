package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TransportSeat;

import java.util.List;

public interface TransportSeatService extends PojoService<TransportSeat> {
    List<TransportSeat> list();
    TransportSeat getById(Integer id);
    TransportSeat save(TransportSeat obj);
    void delete(Integer id);
}
