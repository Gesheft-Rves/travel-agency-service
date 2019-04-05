package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.Tour;
import com.javastudents.travelagency.repository.CrudTest;
import com.javastudents.travelagency.repository.ListTest;
import com.javastudents.travelagency.repository.TourCategoryRepository;
import com.javastudents.travelagency.repository.TourRepository;
import org.intellij.lang.annotations.Language;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class TourRepositoryImplTest extends AbstractTest implements CrudTest, ListTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private TourCategoryRepository tourCategoryRepository;

    @Test
    @Override
    public void createTest() {
        String tourName = "Test tour";
        Tour tour = Tour.builder()
                .name(tourName)
                .description("dded")
                .price(new BigDecimal(2323.2))
                .tourCategory(tourCategoryRepository.read(1))
                .build();
        tourRepository.create(tour);

        @Language("MySQL")
        String sql = "SELECT name FROM tour WHERE tour_id = (SELECT MAX(tour_id) FROM tour)";
        String nameFromDb = jdbcTemplate.queryForObject(sql, String.class);

        assertEquals(tourName, nameFromDb);
    }

    @Test
    @Override
    public void readTest() {
        Tour byId = tourRepository.read(1);

        assertEquals("test", byId.getName());
    }

    @Test
    @Override
    public void updateTest() {
        String nameExpected = "tor New";
        Tour tour = tourRepository.read(1);

        tour.setName(nameExpected);

        tourRepository.update(tour);

        assertEquals(nameExpected, tourRepository.read(1).getName());
    }

    @Test
    @Override
    public void deleteTest() {
        tourRepository.delete(5);

        assertNull(tourRepository.read(5));
    }

    @Test
    @Override
    public void listTest() {
        @Language("MySQL")
        String sql = "SELECT COUNT(*) FROM tour";
        Integer countExpected = jdbcTemplate.queryForObject(sql, Integer.class);
        List<Tour> list = tourRepository.list();
        Integer countActual = list.size();
        assertEquals(countExpected, countActual);
        for (Tour tour : list) {
            assertNotNull(tour.getTourId());
            assertNotNull(tour.getName());
        }

    }
}
