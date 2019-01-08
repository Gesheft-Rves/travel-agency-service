package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.TravelAgency;
import com.javastudents.travelagency.repository.CrudTest;
import com.javastudents.travelagency.repository.TravelAgencyRepository;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.*;

public class TravelAgencyRepositoryImplTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TravelAgencyRepository travelAgencyRepository;

    @Test
    @Override
    public void createTest() {
        String travelAgencyName = "Test travelAgency";
        TravelAgency travelAgency = TravelAgency.builder()
                .abbreviatedName(travelAgencyName)
                .address("dded")
                .phoneNumber("54545")
                .site("ttttyt")
                .emailAddress("hg@mail.ru")
                .build();
        travelAgencyRepository.create(travelAgency);

        @Language("MySQL")
        String sql = "SELECT abbreviated_name from travel_agency where travel_agency_id = (select max(travel_agency_id) from travel_agency)";
        String nameFromDb = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(travelAgencyName, nameFromDb);
    }

    @Test
    @Override
    public void readTest() {
        TravelAgency byId = travelAgencyRepository.read(1);
        Assert.assertNotNull(byId);
        Assert.assertEquals("asd", byId.getAbbreviatedName());
    }

    @Test
    @Override
    public void updateTest() {
        TravelAgency travelAgency = travelAgencyRepository.read(1);

        travelAgency.setAbbreviatedName("travelAgency New");

        travelAgencyRepository.update(travelAgency);

        TravelAgency travelAgencyNew = travelAgencyRepository.read(1);

        Assert.assertNotNull(travelAgencyNew.getId());
        Assert.assertEquals(travelAgency.getId(), travelAgencyNew.getId());
    }

    @Test
    @Override
    public void deleteTest() {
        TravelAgency travelAgency = TravelAgency.builder()
                .abbreviatedName("Test delete")
                .address("dded")
                .phoneNumber("54545")
                .site("ttttyt")
                .emailAddress("hg@mail.ru")
                .build();
        travelAgencyRepository.create(travelAgency);

        @Language("MySQL")
        String sql = "select max(travel_agency_id) from travel_agency";
        int id = jdbcTemplate.queryForObject(sql, int.class);

        TravelAgency travelAgency1 = travelAgencyRepository.read(id);

        Assert.assertNotNull(travelAgency1);

        travelAgencyRepository.delete(id);

        Assert.assertNull(travelAgencyRepository.read(id));
    }
}