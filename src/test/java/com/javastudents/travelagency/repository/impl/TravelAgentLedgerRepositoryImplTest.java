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
        String sql = "SELECT operation_date FROM travel_agent_ledger WHERE travel_agent_ledger_id = (SELECT MAX(travel_agent_ledger_id) FROM travel_agent_ledger)";
        Timestamp operationDate = jdbcTemplate.queryForObject(sql, Timestamp.class);

        Assert.assertEquals(timestamp, operationDate);
    }

    @Test
    @Override
    public void readTest() {
        BigDecimal amountExpected = BigDecimal.valueOf(22222);
        TravelAgentLedger byId = travelAgentLedgerRepository.read(1);
        Assert.assertEquals(amountExpected, byId.getAmount());
    }

    @Test
    @Override
    public void updateTest() {
        BigDecimal amountExpected = new BigDecimal(12.22);

        TravelAgentLedger travelAgentLedger = travelAgentLedgerRepository.read(1);

        travelAgentLedger.setAmount(amountExpected);

        travelAgentLedgerRepository.update(travelAgentLedger);

        Assert.assertEquals(amountExpected, travelAgentLedgerRepository.read(1).getAmount());
    }

    @Test
    @Override
    public void deleteTest() {
        TravelAgentLedger travelAgentLedger = travelAgentLedgerRepository.read(1);

        travelAgentLedgerRepository.delete(travelAgentLedger.getId());

        Assert.assertNull(travelAgentLedgerRepository.read(1));
    }
}