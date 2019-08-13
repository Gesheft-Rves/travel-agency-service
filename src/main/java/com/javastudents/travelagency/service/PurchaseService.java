package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.Purchase;

import java.util.List;

public interface PurchaseService extends PojoService<Purchase> {
    List<Purchase> list();
    Purchase getById(Integer id);
    Purchase save(Purchase obj);
    void delete(Integer id);
}
