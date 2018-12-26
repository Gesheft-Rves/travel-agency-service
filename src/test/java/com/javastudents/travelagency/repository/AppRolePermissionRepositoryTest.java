package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.AppRolePermission;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class AppRolePermissionRepositoryTest extends AbstractTest implements CrudTest {

    @Autowired
    private AppRolePermissionRepository appRolePermissionRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Test
    @Override
    public void createTest() {
        Integer appPermissionId = 4;
        Integer appRoleId = 4;

        AppRolePermission appRolePermission = AppRolePermission.builder()
                .appRoleId(appRoleId)
                .appPermissionId(appPermissionId)
                .build();

        appRolePermissionRepository.create(appRolePermission);

        Integer expected = 5;
        Assert.assertEquals(expected, appRolePermissionRepository.read(5).getAppRolePermissionId());
    }

    @Test
    @Override
    public void readTest() {
        String roleExpected = "appRole_1";
        AppRolePermission byId = appRolePermissionRepository.read(1);
        Integer appRoleId = byId.getAppRoleId();
        String appRoleName = appRoleRepository.read(appRoleId).getName();

        Assert.assertNotNull(byId);
        Assert.assertEquals(roleExpected, appRoleName);
    }

    @Test
    @Override
    public void updateTest() {
        AppRolePermission appRolePermission = appRolePermissionRepository.read(2);
        appRolePermission.setAppRoleId(4);
        appRolePermissionRepository.update(appRolePermission);

        AppRolePermission newAppRolePermission = appRolePermissionRepository.read(2);

        Assert.assertNotNull(newAppRolePermission);
        Assert.assertEquals(appRolePermission.getAppRoleId(), newAppRolePermission.getAppRoleId());
    }

    @Test
    @Override
    public void deleteTest() {

        appRolePermissionRepository.delete(4);

        Assert.assertNull(appRolePermissionRepository.read(4));
    }
}
