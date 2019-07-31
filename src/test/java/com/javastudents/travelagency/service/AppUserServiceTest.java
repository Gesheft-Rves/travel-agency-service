package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.AppUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppUserServiceTest {

    private final TravelAgentService travelAgentService;
    private final AppUserService appUserService;

    @Autowired
    public AppUserServiceTest(TravelAgentService travelAgentService,
                              AppUserService appUserService) {
        this.travelAgentService = travelAgentService;
        this.appUserService = appUserService;
    }

    @Test
    public void list() {
        Integer expected = 4;
        Integer actual = appUserService.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        AppUser appUser = appUserService.getById(1);
        Integer expected = 1;

        Assert.assertEquals(expected,appUser.getAppUserId());
    }

    @Test
    public void save() {
        AppUser appUser = new AppUser(5,"newUserName","newUserSurname","newEmail","Log","Pass",travelAgentService.getById(5));
        appUserService.save(appUser);

        Assert.assertNotNull(appUserService.getById(5));
    }

    @Test
    public void delete() {
        AppUser appUser = new AppUser(5,"newUserName","newUserSurname","newEmail","Log","Pass",travelAgentService.getById(5));
        appUserService.save(appUser);

        Assert.assertNotNull(appUserService.getById(5));

        appUserService.delete(5);

        Assert.assertEquals(4, appUserService.list().size());
    }
}