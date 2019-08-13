package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.TourCategory;
import com.javastudents.travelagency.service.impl.TourCategoryServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TourCategoryServiceImplTest {

    private final TourCategoryServiceImpl tourCategoryService;

    @Autowired
    public TourCategoryServiceImplTest(TourCategoryServiceImpl tourCategoryService) {
        this.tourCategoryService = tourCategoryService;
    }

    @Test
    public void list() {
        Integer expected = 4;
        Integer actual = tourCategoryService.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        TourCategory tourCategory = tourCategoryService.getById(1);
        Integer actual = tourCategory.getId();
        Integer expected = 1;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void save() {
        TourCategory newTourCategory = new TourCategory("newCategory");
        tourCategoryService.save(newTourCategory);

        Assert.assertNotNull(tourCategoryService.getById(5));
    }

    @Test
    public void delete() {
        TourCategory newTourCategory = new TourCategory("newCategory");
        tourCategoryService.save(newTourCategory);

        Assert.assertNotNull(tourCategoryService.getById(5));
        tourCategoryService.delete(5);

        Assert.assertEquals(4,tourCategoryService.list().size());

    }
}