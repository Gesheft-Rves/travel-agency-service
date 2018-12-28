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
        String customerName = "Test tourCategory";
        TourCategory customer = TourCategory.builder()
                .name(customerName)
                .build();
        tourCategoryRepository.create(customer);

        @Language("MySQL")
        String sql = "SELECT name from tour_category where tour_category_id = (select max(tour_category_id) from tour_category)";
        String nameFromDb = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(customerName, nameFromDb);
    }

    @Test
    @Override
    public void readTest() {
        TourCategory byId = tourCategoryRepository.read(1);
        Assert.assertNotNull(byId);
        Assert.assertEquals(byId, byId);
    }

    @Test
    @Override
    public void updateTest() {
        TourCategory tourCategory = tourCategoryRepository.read(1);

        tourCategory.setName("torCategory New");

        tourCategoryRepository.update(tourCategory);

        TourCategory tourCategoryNew = tourCategoryRepository.read(1);

        Assert.assertNotNull(tourCategoryNew);
        Assert.assertEquals(tourCategory.getId(), tourCategoryNew.getId());
    }

    @Test
    @Override
    public void deleteTest() {
        TourCategory tourCategory = tourCategoryRepository.read(2);

        System.out.println(tourCategory.toString());

        //tourCategoryRepository.delete(tourCategory.getName());

        Assert.assertNull(tourCategoryRepository.read('3'));
    }
}