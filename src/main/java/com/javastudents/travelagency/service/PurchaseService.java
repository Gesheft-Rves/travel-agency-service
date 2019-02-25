package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.Purchase;

import java.util.List;

public interface PurchaseService extends CrudService<Purchase> {
    List<Purchase> list();
}
