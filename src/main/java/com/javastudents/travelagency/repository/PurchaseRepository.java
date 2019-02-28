package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.Purchase;
import com.javastudents.travelagency.entity.wrapper.PurchaseWrapper;

import java.util.List;

public interface PurchaseRepository extends CrudRepository<Purchase> {
    List<Purchase> list();
    PurchaseWrapper getPurchaseWrapper();
}
