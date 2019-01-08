package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.AppUserRole;
import org.intellij.lang.annotations.Language;
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

        @Language("MySQL")
        String sqlOld = "SELECT MAX(app_user_role_id) from app_user_role ";
        String oldMaxId = jdbcTemplate.queryForObject(sqlOld, String.class);

        AppUserRole appUserRole = AppUserRole.builder()
                .appUserId(appUserId)
                .roleId(roleId)
                .build();

        repository.create(appUserRole);

        @Language("MySQL")
        String sqlNew = "SELECT MAX(app_user_role_id) from app_user_role ";
        String newMaxId = jdbcTemplate.queryForObject(sqlNew, String.class);

        Assert.assertEquals(Integer.parseInt(oldMaxId)+1,Integer.parseInt(newMaxId));
    }

    @Test
    @Override
    public void readTest() {
        String roleExpected = "appRole_2";
        AppUserRole byId = repository.read(1);
        Integer appRoleId = byId.getRoleId();
        String appRoleName = appRoleRepository.read(appRoleId).getName();

        Assert.assertEquals(roleExpected, appRoleName);
    }

    @Test
    @Override
    public void updateTest() {
        AppUserRole appUserRole = repository.read(2);
        appUserRole.setRoleId(4);
        repository.update(appUserRole);

        Assert.assertEquals(appUserRole.getRoleId(), repository.read(2).getRoleId());
    }

    @Test
    @Override
    public void deleteTest() {

        repository.delete(4);

        Assert.assertNull(repository.read(4));
    }
}
