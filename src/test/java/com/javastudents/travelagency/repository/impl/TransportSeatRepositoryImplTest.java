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
        String sql = "SELECT comment FROM transport_seat WHERE transport_seat_id = (SELECT MAX(transport_seat_id) FROM transport_seat)";
        String commentDB = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(comment, commentDB);
    }

    @Test
    @Override
    public void readTest() {
        String commentExpected = "22";
        TransportSeat byId = transportSeatRepository.read(1);
        Assert.assertEquals(commentExpected, byId.getComment());
    }

    @Test
    @Override
    public void updateTest() {
        String commentExpected = "transportSeat New";

        TransportSeat transportSeat = transportSeatRepository.read(1);

        transportSeat.setComment(commentExpected);

        transportSeatRepository.update(transportSeat);

        Assert.assertEquals(commentExpected, transportSeatRepository.read(1).getComment());
    }

    @Test
    @Override
    public void deleteTest() {
        transportSeatRepository.delete(5);

        Assert.assertNull(transportSeatRepository.read(5));
    }
}