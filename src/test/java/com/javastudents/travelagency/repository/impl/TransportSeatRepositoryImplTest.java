package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.TransportSeat;
import com.javastudents.travelagency.repository.CrudTest;
import com.javastudents.travelagency.repository.TransportSeatRepository;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.*;

public class TransportSeatRepositoryImplTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TransportSeatRepository transportSeatRepository;

    @Test
    @Override
    public void createTest() {
        String comment = "testComment";
        TransportSeat transportSeat = TransportSeat.builder()
                .transportId(2)
                .seatNo(1)
                .comment(comment)
                .build();
        transportSeatRepository.create(transportSeat);

        @Language("MySQL")
        String sql = "SELECT comment from transport_seat where transport_seat_id = (select max(transport_seat_id) from transport_seat)";
        String commentDB = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(comment, commentDB);
    }

    @Test
    @Override
    public void readTest() {
        String commentExpected = "22";
        TransportSeat byId = transportSeatRepository.read(1);
        Assert.assertNotNull(byId);
        Assert.assertEquals(commentExpected, byId.getComment());
    }

    @Test
    @Override
    public void updateTest() {
        TransportSeat transportSeat = transportSeatRepository.read(1);

        transportSeat.setComment("transportSeat New");

        transportSeatRepository.update(transportSeat);

        TransportSeat transportSeatNew = transportSeatRepository.read(1);

        Assert.assertNotNull(transportSeatNew.getId());
        Assert.assertEquals(transportSeat.getId(), transportSeatNew.getId());
    }

    @Test
    @Override
    public void deleteTest() {
        TransportSeat transportSeat = TransportSeat.builder()
                .transportId(2)
                .seatNo(2)
                .comment("comment")
                .build();
        transportSeatRepository.create(transportSeat);

        @Language("MySQL")
        String sql = "select max(transport_seat_id) from transport_seat";
        int id = jdbcTemplate.queryForObject(sql, int.class);

        TransportSeat transportSeat1 = transportSeatRepository.read(id);

        Assert.assertNotNull(transportSeat1);

        transportSeatRepository.delete(id);

        Assert.assertNull(transportSeatRepository.read(id));
    }
}