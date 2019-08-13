package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.Client;

import java.util.List;

public interface ClientService extends PojoService<Client> {
    List<Client> list();
    Client getById(Integer id);
    Client save(Client obj);
    void delete(Integer id);
}
