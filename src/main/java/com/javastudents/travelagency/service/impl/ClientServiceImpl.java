package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.Client;
import com.javastudents.travelagency.repository.ClientRepository;
import com.javastudents.travelagency.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @Autowired
    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Client client) {
        repository.create(client);
    }

    @Override
    public Client read(int clientId) {
        return repository.read(clientId);
    }

    @Override
    public void update(Client client) {
        repository.update(client);
    }

    @Override
    public void delete(int clientId) {
        repository.delete(clientId);
    }
}
