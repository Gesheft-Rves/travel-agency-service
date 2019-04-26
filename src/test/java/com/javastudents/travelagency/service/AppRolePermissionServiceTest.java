package com.javastudents.travelagency.service;

import com.javastudents.travelagency.entity.AppRolePermission;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppRolePermissionServiceTest {

    private AppRolePermissionService appRolePermissionService;

    @Autowired
    public void setAppRolePermissionService(AppRolePermissionService appRolePermissionService) {
        this.appRolePermissionService = appRolePermissionService;
    }

    @Test
    public void list() {
        Integer expected = 4;
        Integer actual = appRolePermissionService.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        AppRolePermission appRolePermission = appRolePermissionService.getById(1);
        Integer expected = 1;

        Assert.assertEquals(expected,appRolePermission.getAppRolePermissionId());
    }

    @Test
    public void save() {
        AppRolePermission newAppRolePermision = new AppRolePermission(5,1,2);
        appRolePermissionService.save(newAppRolePermision);

        Assert.assertNotNull(appRolePermissionService.getById(5));
    }

    @Test
    public void delete() {
        AppRolePermission newAppRolePermision = new AppRolePermission(5,1,2);
        appRolePermissionService.save(newAppRolePermision);

        Assert.assertNotNull(appRolePermissionService.getById(5));

        appRolePermissionService.delete(5);

        Assert.assertEquals(4, appRolePermissionService.list().size());
    }
}