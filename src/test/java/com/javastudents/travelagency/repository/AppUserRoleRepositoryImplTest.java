package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.AppUserRole;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


public class AppUserRoleRepositoryImplTest extends AbstractTest implements CrudTest{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AppUserRoleRepository appUserRoleRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Test
    @Override
    public void createTest() {
        Integer appUserId = 1;
        Integer roleId = 2;

        @Language("MySQL")
        String sqlOld = "SELECT MAX(app_user_role_id) from app_user_role ";
        Integer oldMaxId = jdbcTemplate.queryForObject(sqlOld, Integer.class);

        AppUserRole appUserRole = AppUserRole.builder()
                .appUserId(appUserId)
                .roleId(roleId)
                .build();

        appUserRoleRepository.create(appUserRole);

        @Language("MySQL")
        String sqlNew = "SELECT MAX(app_user_role_id) from app_user_role ";
        Integer newMaxId = jdbcTemplate.queryForObject(sqlNew, Integer.class);

        oldMaxId+=1;

        Assert.assertEquals(oldMaxId,newMaxId);
    }

    @Test
    @Override
    public void readTest() {
        String nameRoleExpected = "appRole_2";
        AppUserRole byId = appUserRoleRepository.read(1);
        Integer appRoleId = byId.getRoleId();
        String appRoleName = appRoleRepository.read(appRoleId).getName();

        Assert.assertEquals(nameRoleExpected, appRoleName);
    }

    @Test
    @Override
    public void updateTest() {
        AppUserRole appUserRole = appUserRoleRepository.read(2);
        appUserRole.setRoleId(4);
        appUserRoleRepository.update(appUserRole);

        Assert.assertEquals(appUserRole.getRoleId(), appUserRoleRepository.read(2).getRoleId());
    }

    @Test
    @Override
    public void deleteTest() {
        appUserRoleRepository.delete(4);

        Assert.assertNull(appUserRoleRepository.read(4));
    }
}
