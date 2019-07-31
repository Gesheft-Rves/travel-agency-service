package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.Purchase;
import com.javastudents.travelagency.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PurchaseService implements PojoService<Purchase>{

    private final PurchaseRepository repository;

    @Autowired
    public PurchaseService(PurchaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Purchase> list() {
        return repository.findAll();
    }

    @Override
    public Purchase getById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public Purchase save(Purchase obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(getById(id));
    }
}
