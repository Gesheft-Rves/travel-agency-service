package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.Purchase;

import java.util.List;

public interface PurchaseRepository extends CrudRepository<Purchase> {
    List<Purchase> list();
}
