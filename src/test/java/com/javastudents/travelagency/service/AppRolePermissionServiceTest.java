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

    private final AppRolePermissionService appRolePermissionService;
    private final AppRoleService appRoleService;
    private final AppPermissionService appPermissionService;

    @Autowired
    public AppRolePermissionServiceTest(AppRolePermissionService appRolePermissionService,
                                        AppRoleService appRoleService,
                                        AppPermissionService appPermissionService) {
        this.appRolePermissionService = appRolePermissionService;
        this.appRoleService = appRoleService;
        this.appPermissionService = appPermissionService;
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
        AppRolePermission newAppRolePermision = new AppRolePermission(5,appRoleService.getById(1),appPermissionService.getById(2));
        appRolePermissionService.save(newAppRolePermision);

        Assert.assertNotNull(appRolePermissionService.getById(5));
    }

    @Test
    public void delete() {
        AppRolePermission newAppRolePermision = new AppRolePermission(5,appRoleService.getById(1),appPermissionService.getById(2));
        appRolePermissionService.save(newAppRolePermision);

        Assert.assertNotNull(appRolePermissionService.getById(5));

        appRolePermissionService.delete(5);

        Assert.assertEquals(4, appRolePermissionService.list().size());
    }
}