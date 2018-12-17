package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.Purchase;
import com.javastudents.travelagency.repository.PurchaseRepository;
import com.javastudents.travelagency.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository repository;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Purchase entity) {

    }

    @Override
    public Purchase read(int id) {
        return null;
    }

    @Override
    public void update(Purchase entity) {

    }

    @Override
    public void delete(int id) {

    }
}
