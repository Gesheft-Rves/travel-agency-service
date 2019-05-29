package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.Tour;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TourServiceTest {

    private final TourService tourService;
    private final TourCategoryService tourCategoryService;

    @Autowired
    public TourServiceTest(TourService tourService,
                           TourCategoryService tourCategoryService) {
        this.tourService = tourService;
        this.tourCategoryService = tourCategoryService;
    }

    @Test
    public void list() {
        Integer expected = 2;
        Integer actual = tourService.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        Tour tour = tourService.getById(1);
        Integer actual =  tour.getId();
        Integer expected = 1;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void save() {
        Tour newTour = new Tour("test228","test228", new BigDecimal(2222),tourCategoryService.getById(1));
        tourService.save(newTour);

        Assert.assertNotNull(tourService.getById(3));
    }

    @Test
    public void delete() {
        Tour newTour = new Tour("test200","test200", new BigDecimal(2222),tourCategoryService.getById(1));
        tourService.save(newTour);

        Assert.assertNotNull(tourService.getById(3));

        tourService.delete(3);
        Assert.assertEquals(2,tourService.list().size());
    }
}