package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.Purchase;
import com.javastudents.travelagency.repository.CrudTest;
import com.javastudents.travelagency.repository.PurchaseRepository;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.Assert.*;

public class PurchaseRepositoryTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PurchaseRepository repository;

    @Test
    @Override
    public void createTest() {
        String departmentName = "Test";
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        //просто мысли. Ты вставляешь 1 везде. Это значит что записи такие в других таблицах должны быть
        Purchase purchase = Purchase.builder()
                .tourScheduleId(1)
                .travelAgentId(1)
                .clientId(1)
                .transportId(1)
                .transportSeatId(1)
                .operationDate(timestamp)
                .build();

        repository.create(purchase);

        @Language("MySQL")
        String sql = "SELECT name from purchase where purchase_id = (select max(purchase_id) from purchase)";

        String nameFromDb = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(departmentName, nameFromDb);
    }

    @Test
    @Override
    public void readTest() {

        Purchase byName = repository.read(2);

        int id = byName.getId();

        Purchase byId = repository.read(id);


        Assert.assertNotNull(byId);
        Assert.assertNotNull(byName);
        Assert.assertEquals(byName, byId);
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