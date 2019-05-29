package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.AppUserRole;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppUserRoleServiceTest {

    private final AppUserRoleService appUserRoleService;
    private final AppUserService appUserService;
    private final AppRoleService appRoleService;

    @Autowired
    public AppUserRoleServiceTest(AppUserRoleService appUserRoleService,
                                  AppUserService appUserService,
                                  AppRoleService appRoleService) {
        this.appUserRoleService = appUserRoleService;
        this.appUserService = appUserService;
        this.appRoleService = appRoleService;
    }

    @Test
    public void list() {
        Integer expected = 3;
        Integer actual = appUserRoleService.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        AppUserRole appUserRole = appUserRoleService.getById(1);
        Integer expected = 1;

        Assert.assertEquals(expected,appUserRole.getAppUserRoleId());
    }

    @Test
    public void save() {
        AppUserRole newAppUserRole = new AppUserRole(appUserService.getById(2),appRoleService.getById(3));
        appUserRoleService.save(newAppUserRole);

        Assert.assertNotNull(appUserService.getById(5));
    }

    @Test
    public void delete() {
        AppUserRole newAppUserRole = new AppUserRole(appUserService.getById(2),appRoleService.getById(3));
        appUserRoleService.save(newAppUserRole);

        Assert.assertNotNull(appUserService.getById(5));

        appUserRoleService.delete(4);

        Assert.assertEquals(3, appUserRoleService.list().size());

    }
}