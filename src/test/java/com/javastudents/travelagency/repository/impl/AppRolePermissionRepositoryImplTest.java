package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.AppRolePermission;
import com.javastudents.travelagency.entity.wrapper.AppRolePermissionWrapper;
import com.javastudents.travelagency.repository.AppRolePermissionRepository;
import com.javastudents.travelagency.repository.AppRoleRepository;
import com.javastudents.travelagency.repository.CrudTest;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class AppRolePermissionRepositoryImplTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AppRolePermissionRepository appRolePermissionRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Test
    @Override
    public void createTest() {
        Integer appPermissionId = 4;
        Integer appRoleId = 4;

        @Language("MySQL")
        String sqlOld = "SELECT MAX(app_role_permission_id) from app_role_permission ";
        Integer oldMaxId = jdbcTemplate.queryForObject(sqlOld, Integer.class) ;

        AppRolePermission appRolePermission = AppRolePermission.builder()
                .appRoleId(appRoleId)
                .appPermissionId(appPermissionId)
                .build();

        appRolePermissionRepository.create(appRolePermission);

        @Language("MySQL")
        String sqlNew = "SELECT MAX(app_role_permission_id) from app_role_permission ";
        Integer newMaxId = jdbcTemplate.queryForObject(sqlNew, Integer.class);
        oldMaxId += 1;
        Assert.assertEquals(oldMaxId, newMaxId);
    }

    @Test
    @Override
    public void readTest() {
        AppRolePermission byId = appRolePermissionRepository.read(1);
        Integer expected = 1;
        Assert.assertEquals(expected, byId.getAppRoleId());
    }

    @Test
    @Override
    public void updateTest() {
        AppRolePermission appRolePermission = appRolePermissionRepository.read(2);
        appRolePermission.setAppRoleId(4);
        appRolePermissionRepository.update(appRolePermission);

        String expectedRole = appRoleRepository.read(4).getName();
        String receivedRole = appRoleRepository.read(appRolePermissionRepository.read(2).getAppRoleId()).getName();

        Assert.assertEquals(expectedRole, receivedRole);
    }

    @Test
    @Override
    public void deleteTest() {
        appRolePermissionRepository.delete(4);

        Assert.assertNull(appRolePermissionRepository.read(4));
    }

    @Test
    public void listTest() {
        Integer expectedSize = 4;

        List<AppRolePermission> appRolePermissionList = appRolePermissionRepository.list();

        Assert.assertEquals(expectedSize,  (Integer) appRolePermissionList.size());
    }

    @Test
    public void appRolePermissionWrapperListTest() {
        Integer expectedSize = 4;

        List<AppRolePermissionWrapper> appRolePermissionWrapperList = appRolePermissionRepository.appRolePermissionWrapperList();

        Assert.assertEquals(expectedSize,  (Integer) appRolePermissionWrapperList.size());
    }

    @Test
    public void readAppRolePermissionWrapperTest() {
        Integer expectedSize = 5;
        Integer appRoleId = 1;
        Integer appPermissionId = 2;


        AppRolePermission appRolePermission = AppRolePermission.builder()
                .appRoleId(appRoleId)
                .appPermissionId(appPermissionId)
                .build();

        appRolePermissionRepository.create(appRolePermission);

        AppRolePermissionWrapper test = appRolePermissionRepository.readAppRolePermissionWrapper(5);

        Assert.assertNotNull(test);

        Assert.assertEquals(expectedSize,  (Integer) appRolePermissionRepository.appRolePermissionWrapperList().size());
    }
}
