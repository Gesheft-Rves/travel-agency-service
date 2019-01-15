package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.TourCategory;
import com.javastudents.travelagency.repository.CrudTest;
import com.javastudents.travelagency.repository.TourCategoryRepository;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.Assert.*;

public class TourCategoryRepositoryImplTest extends AbstractTest implements CrudTest {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TourCategoryRepository tourCategoryRepository;


    @Test
    @Override
    public void createTest() {
        String tourCategoryName = "Test tourCategory";
        TourCategory tourCategory = TourCategory.builder()
                .name(tourCategoryName)
                .build();
        tourCategoryRepository.create(tourCategory);

        @Language("MySQL")
        String sql = "SELECT name FROM tour_category WHERE tour_category_id = (SELECT MAX(tour_category_id) FROM tour_category)";
        String nameFromDb = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(tourCategoryName, nameFromDb);
    }

    @Test
    @Override
    public void readTest() {
        TourCategory byId = tourCategoryRepository.read(1);

        Assert.assertEquals("1", byId.getName());
    }

    @Test
    @Override
    public void updateTest() {
        String nameExpected = "tourCategoryNew";

        TourCategory tourCategory = tourCategoryRepository.read(1);

        tourCategory.setName(nameExpected);

        tourCategoryRepository.update(tourCategory);

        Assert.assertEquals(nameExpected, tourCategoryRepository.read(1).getName());
    }

    @Test
    @Override
    public void deleteTest() {
        TourCategory tourCategory = tourCategoryRepository.read(2);

        tourCategoryRepository.delete(tourCategory.getId());

        Assert.assertNull(tourCategoryRepository.read(2));
    }
}