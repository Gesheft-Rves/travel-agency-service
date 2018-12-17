package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.Purchase;
import com.javastudents.travelagency.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class PurchaseRepositoryImpl implements PurchaseRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PurchaseRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Purchase purchase) {

    }

    @Override
    public Purchase read(int purchaseId) {
        return null;
    }

    @Override
    public void update(Purchase purchase) {

    }

    @Override
    public void delete(int purchaseId) {

    }
}
