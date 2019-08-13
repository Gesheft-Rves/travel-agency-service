package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.Tour;
import com.javastudents.travelagency.service.impl.TourCategoryServiceImpl;
import com.javastudents.travelagency.service.impl.TourServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TourServiceImplTest {

    private final TourServiceImpl tourServiceImpl;
    private final TourCategoryServiceImpl tourCategoryService;

    @Autowired
    public TourServiceImplTest(TourServiceImpl tourServiceImpl,
                               TourCategoryServiceImpl tourCategoryService) {
        this.tourServiceImpl = tourServiceImpl;
        this.tourCategoryService = tourCategoryService;
    }

    @Test
    public void list() {
        Integer expected = 2;
        Integer actual = tourServiceImpl.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        Tour tour = tourServiceImpl.getById(1);
        Integer actual =  tour.getId();
        Integer expected = 1;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void save() {
        Tour newTour = new Tour("test228","test228", new BigDecimal(2222),tourCategoryService.getById(1));
        tourServiceImpl.save(newTour);

        Assert.assertNotNull(tourServiceImpl.getById(3));
    }

    @Test
    public void delete() {
        Tour newTour = new Tour("test200","test200", new BigDecimal(2222),tourCategoryService.getById(1));
        tourServiceImpl.save(newTour);

        Assert.assertNotNull(tourServiceImpl.getById(3));

        tourServiceImpl.delete(3);
        Assert.assertEquals(2, tourServiceImpl.list().size());
    }
}