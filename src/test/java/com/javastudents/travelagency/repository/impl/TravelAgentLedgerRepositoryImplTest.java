package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.TravelAgentLedger;
import com.javastudents.travelagency.repository.CrudTest;
import com.javastudents.travelagency.repository.TravelAgentLedgerRepository;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.sql.Timestamp;

import static org.junit.Assert.*;

public class TravelAgentLedgerRepositoryImplTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TravelAgentLedgerRepository travelAgentLedgerRepository;

    @Test
    @Override
    public void createTest() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        TravelAgentLedger travelAgentLedger = TravelAgentLedger.builder()
                .travelAgentId(1)
                .operationDate(timestamp)
                .purchaseId(1)
                .amount(new BigDecimal(1212.5))
                .build();
        travelAgentLedgerRepository.create(travelAgentLedger);

        @Language("MySQL")
        String sql = "SELECT operation_date from travel_agent_ledger where travel_agent_ledger_id = (select max(travel_agent_ledger_id) from travel_agent_ledger)";
        Timestamp operationDate = jdbcTemplate.queryForObject(sql, Timestamp.class);

        Assert.assertEquals(timestamp, operationDate);
    }

    @Test
    @Override
    public void readTest() {
        TravelAgentLedger byId = travelAgentLedgerRepository.read(1);
        Assert.assertNotNull(byId);
        Assert.assertEquals(1, byId);
    }

    @Test
    @Override
    public void updateTest() {
        TravelAgentLedger travelAgentLedger = travelAgentLedgerRepository.read(1);

        travelAgentLedger.setAmount(new BigDecimal(212.2));

        travelAgentLedgerRepository.update(travelAgentLedger);

        TravelAgentLedger travelAgentLedgerNew = travelAgentLedgerRepository.read(1);

        Assert.assertNotNull(travelAgentLedgerNew.getId());
        Assert.assertEquals(travelAgentLedger.getId(), travelAgentLedgerNew.getId());
    }

    @Test
    @Override
    public void deleteTest() {
        TravelAgentLedger travelAgentLedger = travelAgentLedgerRepository.read(1);

        travelAgentLedgerRepository.delete(travelAgentLedger.getId());

        Assert.assertNull(travelAgentLedgerRepository.read(1));
    }
}