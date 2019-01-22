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
        String sql = "SELECT operation_date FROM purchase WHERE purchase_id = (SELECT MAX(purchase_id) FROM purchase)";

        Timestamp operationDate = jdbcTemplate.queryForObject(sql, Timestamp.class);

        Assert.assertEquals(timestamp, operationDate);
    }

    @Test
    @Override
    public void readTest() {

        Integer expected = 1;

        Purchase byId = purchaseRepository.read(1);

        Assert.assertEquals(expected, byId.getTourScheduleId());
        Assert.assertEquals(expected, byId.getTravelAgentId());
        Assert.assertEquals(expected, byId.getClientId());
        Assert.assertEquals(expected, byId.getClientId());
        Assert.assertEquals(expected, byId.getTransportSeatId());
    }

    @Test
    @Override
    public void updateTest() {
        Timestamp operationDateExpected = new Timestamp(System.currentTimeMillis());
        Purchase purchase = purchaseRepository.read(1);

        Timestamp operationDateOld = purchase.getOperationDate();

        purchase.setOperationDate(operationDateExpected);

        purchaseRepository.update(purchase);

        Assert.assertNotEquals(operationDateOld, purchaseRepository.read(1).getOperationDate());
        Assert.assertEquals(operationDateExpected,purchaseRepository.read(1).getOperationDate());
    }

    @Test
    @Override
    public void deleteTest() {
        purchaseRepository.delete(5);

        Assert.assertNull(purchaseRepository.read(5));
    }
}