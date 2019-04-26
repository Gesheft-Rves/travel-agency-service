package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.AppRole;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppRoleServiceTest {

    private AppRoleService appRoleService;

    @Autowired
    public void setAppRoleService(AppRoleService appRoleService) {
        this.appRoleService = appRoleService;
    }

    @Test
    public void list() {
        Integer expected = 4;
        Integer actual = appRoleService.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        AppRole appRole = appRoleService.getById(1);
        Integer expected = 1;

        Assert.assertEquals(expected,appRole.getAppRoleId());
    }

    @Test
    public void save() {
        AppRole newAppRole = new AppRole(5,"newAppRoleName");
        appRoleService.save(newAppRole);

        Assert.assertNotNull(appRoleService.getById(5));
    }

    @Test
    public void delete() {
        AppRole newAppRole = new AppRole(5,"newAppRoleName");
        appRoleService.save(newAppRole);

        Assert.assertNotNull(appRoleService.getById(5));

        appRoleService.delete(5);

        Assert.assertEquals(4, appRoleService.list().size());
    }
}