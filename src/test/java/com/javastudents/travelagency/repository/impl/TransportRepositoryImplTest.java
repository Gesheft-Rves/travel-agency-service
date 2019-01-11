package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.Transport;
import com.javastudents.travelagency.repository.CrudTest;
import com.javastudents.travelagency.repository.TransportRepository;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TransportRepositoryImplTest extends AbstractTest implements CrudTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TransportRepository transportRepository;


    @Test
    @Override
    public void createTest() {
        String transportName = "Test transport";
        Transport transport = Transport.builder()
                .name(transportName)
                .description("dded")
                .passengerSeatQty(5)
                .build();
        transportRepository.create(transport);

        @Language("MySQL")
        String sql = "SELECT name from transport where transport_id = (select max(transport_id) from transport)";
        String nameFromDb = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(transportName, nameFromDb);
    }

    @Test
    @Override
    public void readTest() {
        String descriptionExpected = "2";
        Transport byId = transportRepository.read(1);

        Assert.assertEquals(descriptionExpected, byId.getDescription());
    }

    @Test
    @Override
    public void updateTest() {
        Transport transport = transportRepository.read(1);

        transport.setName("transport New");
        transportRepository.update(transport);

        Transport transportNew = transportRepository.read(1);

        Assert.assertEquals(transport.getId(), transportNew.getId());
    }

    @Test
    @Override
    public void deleteTest() {
        transportRepository.delete(5);

        Assert.assertNull(transportRepository.read(5));
    }
}