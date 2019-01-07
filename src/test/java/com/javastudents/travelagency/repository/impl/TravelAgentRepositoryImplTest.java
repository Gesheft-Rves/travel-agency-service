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
        String sql = "SELECT name from travel_agent where travel_agent_id = (select max(travel_agent_id) from travel_agent)";

        String nameFromDb = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(travelAgentName, nameFromDb);
    }

    @Test
    @Override
    public void readTest() {
        String nameExpected = "test1";

        TravelAgent byId = travelAgentRepository.read(1);
        Assert.assertNotNull(byId);
        Assert.assertEquals(nameExpected, byId.getName());
    }

    @Test
    @Override
    public void updateTest() {
        TravelAgent travelAgent = travelAgentRepository.read(1);

        travelAgent.setName("travelAgent new");

        travelAgentRepository.update(travelAgent);

        TravelAgent travelAgentNew = travelAgentRepository.read(1);

        Assert.assertNotNull(travelAgentNew.getId());
        Assert.assertEquals(travelAgent.getId(), travelAgentNew.getId());
    }

    @Test
    @Override
    public void deleteTest() {
        TravelAgent travelAgent = TravelAgent.builder()
                .travelAgencyId(1)
                .name("test delete")
                .surname("testT")
                .patronymic("s")
                .enabled(true)
                .phoneNumber("4646546")
                .limitAmount(new BigDecimal(455.8454))
                .build();
        travelAgentRepository.create(travelAgent);

        @Language("MySQL")
        String sql = "select max(travel_agent_id) from travel_agent";
        int id = jdbcTemplate.queryForObject(sql, int.class);

        TravelAgent travelAgent1 = travelAgentRepository.read(id);

        Assert.assertNotNull(travelAgent1);

        travelAgentRepository.delete(id);

        Assert.assertNull(travelAgentRepository.read(id));
    }
}