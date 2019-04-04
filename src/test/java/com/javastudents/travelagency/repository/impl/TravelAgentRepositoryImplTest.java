package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.TravelAgency;
import com.javastudents.travelagency.entity.TravelAgent;
import com.javastudents.travelagency.repository.CrudTest;
import com.javastudents.travelagency.repository.ListTest;
import com.javastudents.travelagency.repository.TravelAgencyRepository;
import com.javastudents.travelagency.repository.TravelAgentRepository;
import org.intellij.lang.annotations.Language;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TravelAgentRepositoryImplTest extends AbstractTest implements CrudTest, ListTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TravelAgentRepository travelAgentRepository;
    @Autowired
    private TravelAgencyRepository travelAgencyRepository;

    @Test
    @Override
    public void createTest() {
        String travelAgentName = "Test";

        TravelAgent travelAgent = TravelAgent.builder()
                .travelAgency(travelAgencyRepository.read(1))
                .name(travelAgentName)
                .surname("testT")
                .patronymic("s")
                .enabled(true)
                .phoneNumber("4646546")
                .limitAmount(new BigDecimal(455.8454))
                .build();

        travelAgentRepository.create(travelAgent);

        @Language("MySQL")
        String sql = "SELECT name FROM  WHERE travel_agent_id = (SELECT max(travel_agent_id) FROM travel_agent)";

        String nameFromDb = jdbcTemplate.queryForObject(sql, String.class);

        assertEquals(travelAgentName, nameFromDb);
    }

    @Test
    @Override
    public void readTest() {
        String nameExpected = "agent_name_1";

        TravelAgent byId = travelAgentRepository.read(1);
        assertEquals(nameExpected, byId.getName());
    }

    @Test
    @Override
    public void updateTest() {
        String nameExpected = "travelAgent new";

        TravelAgent travelAgent = travelAgentRepository.read(1);

        travelAgent.setName(nameExpected);

        travelAgentRepository.update(travelAgent);

        assertEquals(nameExpected, travelAgentRepository.read(1).getName());
    }

    @Test
    @Override
    public void deleteTest() {
        travelAgentRepository.delete(5);

        assertNull(travelAgentRepository.read(5));
    }

    @Test
    @Override
    public void listTest(){
        @Language("MySQL")
        String sql = "SELECT COUNT(*) FROM travel_agent";
        Integer countExpected = jdbcTemplate.queryForObject(sql, Integer.class);
        List<TravelAgent> list = travelAgentRepository.list();
        Integer countActual = list.size();
        assertEquals(countExpected, countActual);
        for (TravelAgent travelAgent : list) {
            assertNotNull(travelAgent.getId());
            assertNotNull(travelAgent.getName());
        }
    }
}