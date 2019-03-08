package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.Purchase;
import com.javastudents.travelagency.entity.wrapper.PurchaseWrapper;

import java.util.List;

public interface PurchaseService extends CrudService<Purchase> {
    List<Purchase> list();
    List<PurchaseWrapper> listWrapper();
    PurchaseWrapper readWrapper(int id);
    void updateWrapper(PurchaseWrapper purchaseWrapper);
}
