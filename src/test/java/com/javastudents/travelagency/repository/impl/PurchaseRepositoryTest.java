package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.repository.CrudTest;
import com.javastudents.travelagency.repository.PurchaseRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.*;

public class PurchaseRepositoryTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PurchaseRepository repository;

    @Test
    @Override
    public void createTest() {
    }

    @Test
    @Override
    public void readTest() {
    }

    @Test
    @Override
    public void updateTest() {
    }

    @Test
    @Override
    public void deleteTest() {
    }
}