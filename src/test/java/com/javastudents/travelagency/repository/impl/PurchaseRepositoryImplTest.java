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

public class PurchaseRepositoryImplTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Test
    @Override
    public void createTest() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Purchase purchase = Purchase.builder()
                .tourScheduleId(1)
                .travelAgentId(2)
                .clientId(2)
                .transportId(2)
                .transportSeatId(2)
                .operationDate(timestamp)
                .build();

        purchaseRepository.create(purchase);

        @Language("MySQL")
        String sql = "SELECT operation_date from purchase where purchase_id = (select max(purchase_id) from purchase)";

        Timestamp operationDate = jdbcTemplate.queryForObject(sql, Timestamp.class);

        Assert.assertEquals(timestamp, operationDate);
    }

    @Test
    @Override
    public void readTest() {

        Purchase byName = purchaseRepository.read(1);

        int id = byName.getId();

        Purchase byId = purchaseRepository.read(id);


        Assert.assertNotNull(byId);
        Assert.assertNotNull(byName);
        Assert.assertEquals(byName, byId);
    }

    @Test
    @Override
    public void updateTest() {
        Purchase purchase = purchaseRepository.read(1);
        Timestamp test = purchase.getOperationDate();
        Integer id = purchase.getId();

        purchase.setOperationDate(new Timestamp(System.currentTimeMillis()));

        purchaseRepository.update(purchase);

        Assert.assertNotNull(purchaseRepository.read(id));
        Assert.assertEquals(id, purchaseRepository.read(id).getId());
        Assert.assertNotEquals(test, purchaseRepository.read(1).getOperationDate());
    }

    @Test
    @Override
    public void deleteTest() {
        Purchase purchase = Purchase.builder()
                .tourScheduleId(1)
                .travelAgentId(2)
                .clientId(2)
                .transportId(2)
                .transportSeatId(2)
                .operationDate(new Timestamp(System.currentTimeMillis()))
                .build();
        purchaseRepository.create(purchase);

        @Language("MySQL")
        String sql = "select max(purchase_id) from purchase";
        int id = jdbcTemplate.queryForObject(sql, int.class);

        Purchase transportSeat1 = purchaseRepository.read(id);

        Assert.assertNotNull(transportSeat1);

        purchaseRepository.delete(id);

        Assert.assertNull(purchaseRepository.read(id));
    }
}