package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.TravelAgent;
import com.javastudents.travelagency.repository.CrudTest;
import com.javastudents.travelagency.repository.TravelAgentRepository;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TravelAgentRepositoryImplTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TravelAgentRepository travelAgentRepository;

    @Test
    @Override
    public void createTest() {
        String travelAgentName = "Test";

        TravelAgent travelAgent = TravelAgent.builder()
                .travelAgencyId(1)
                .name(travelAgentName)
                .surname("testT")
                .patronymic("s")
                .enabled(true)
                .phoneNumber("4646546")
                .limitAmount(new BigDecimal(455.8454))
                .build();

        travelAgentRepository.create(travelAgent);

        @Language("MySQL")
        String sql = "SELECT name FROM travel_agent WHERE travel_agent_id = (SELECT max(travel_agent_id) FROM travel_agent)";

        String nameFromDb = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(travelAgentName, nameFromDb);
    }

    @Test
    @Override
    public void readTest() {
        String nameExpected = "test1";

        TravelAgent byId = travelAgentRepository.read(1);
        Assert.assertEquals(nameExpected, byId.getName());
    }

    @Test
    @Override
    public void updateTest() {
        String nameExpected = "travelAgent new";

        TravelAgent travelAgent = travelAgentRepository.read(1);

        travelAgent.setName(nameExpected);

        travelAgentRepository.update(travelAgent);

        Assert.assertEquals(nameExpected, travelAgentRepository.read(1).getName());
    }

    @Test
    @Override
    public void deleteTest() {
        travelAgentRepository.delete(5);

        Assert.assertNull(travelAgentRepository.read(5));
    }
}