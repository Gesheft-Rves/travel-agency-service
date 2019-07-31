package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.Client;
import com.javastudents.travelagency.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements PojoService<Client> {

    private final ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Client> list() {
        return repository.findAll();
    }

    @Override
    public Client getById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public Client save(Client obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(getById(id));
    }
}
