package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.Transport;

import java.util.List;

public interface TransportService extends PojoService<Transport> {
    List<Transport> list();
    Transport getById(Integer id);
    Transport save(Transport obj);
    void delete(Integer id);
}
