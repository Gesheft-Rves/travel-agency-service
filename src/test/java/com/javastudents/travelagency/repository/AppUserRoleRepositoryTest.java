package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.AppUserRole;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AppUserRoleRepositoryTest extends AbstractTest implements CrudTest{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AppUserRoleRepository repository;

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Test
    @Override
    public void createTest() {
        Integer appUserId = 1;
        Integer roleId = 2;

        AppUserRole appUserRole = AppUserRole.builder()
                .appUserId(appUserId)
                .roleId(roleId)
                .build();

        repository.create(appUserRole);


        Integer expected = 4;
        Assert.assertNotNull(repository.read(4));
        Assert.assertEquals(expected, repository.read(4).getAppUserRoleId());
    }

    @Test
    @Override
    public void readTest() {
        String roleExpected = "appRole_2";
        AppUserRole byId = repository.read(1);
        Integer appRoleId = byId.getRoleId();
        String appRoleName = appRoleRepository.read(appRoleId).getName();

        Assert.assertNotNull(byId);
        Assert.assertEquals(roleExpected, appRoleName);
    }

    @Test
    @Override
    public void updateTest() {
        AppUserRole appUserRole = repository.read(2);
        appUserRole.setRoleId(4);
        repository.update(appUserRole);

        AppUserRole newAppUserRole = repository.read(2);

        Assert.assertNotNull(newAppUserRole);
        Assert.assertEquals(appUserRole.getRoleId(), newAppUserRole.getRoleId());
    }

    @Test
    @Override
    public void deleteTest() {
        repository.delete(4);
        Assert.assertNull(repository.read(4));
    }
}
