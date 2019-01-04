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
        String purchaseName = "Test";
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Purchase purchase = Purchase.builder()
                .tourScheduleId(1)
                .travelAgentId(1)
                .clientId(1)
                .transportId(1)
                .transportSeatId(1)
                .operationDate(timestamp)
                .build();

        purchaseRepository.create(purchase);

        @Language("MySQL")
        String sql = "SELECT name from purchase where purchase_id = (select max(purchase_id) from purchase)";

        String nameFromDb = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(purchaseName, nameFromDb);
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
        Purchase tourCategory = purchaseRepository.read(1);

        purchaseRepository.delete(tourCategory.getId());

        Assert.assertNull(purchaseRepository.read(1));
    }
}