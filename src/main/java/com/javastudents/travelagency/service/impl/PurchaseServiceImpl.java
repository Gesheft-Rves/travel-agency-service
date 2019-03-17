package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.Purchase;
import com.javastudents.travelagency.repository.PurchaseRepository;
import com.javastudents.travelagency.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository repository;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Purchase purchase) {
        repository.create(purchase);
    }

    @Override
    public Purchase read(int purchaseId) {
        return repository.read(purchaseId);
    }

    @Override
    public void update(Purchase purchase) {
        repository.update(purchase);
    }

    @Override
    public void delete(int purchaseId) {
        repository.delete(purchaseId);
    }

    @Override
    public List<Purchase> list() {
        return repository.list();
    }

}
