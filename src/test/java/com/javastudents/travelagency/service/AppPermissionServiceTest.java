package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.AppPermission;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppPermissionServiceTest {

    private final AppPermissionService appPermissionService;

    @Autowired
    public AppPermissionServiceTest(AppPermissionService appPermissionService) {
        this.appPermissionService = appPermissionService;
    }

    @Test
    public void list() {
        Integer expected = 4;
        Integer actual = appPermissionService.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        AppPermission appPermission = appPermissionService.getById(1);
        Integer actual = appPermission.getAppPermissionId();
        Integer expected = 1;

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void save() {
        AppPermission newAppPermission = new AppPermission(5,"newAppPermission");
        appPermissionService.save(newAppPermission);

        Assert.assertNotNull(appPermissionService.getById(5));
    }

    @Test
    public void delete() {
        AppPermission newAppPermission = new AppPermission(5,"newAppPermission");
        appPermissionService.save(newAppPermission);

        Assert.assertNotNull(appPermissionService.getById(5));

        appPermissionService.delete(5);
        Assert.assertEquals(4,appPermissionService.list().size());
    }
}