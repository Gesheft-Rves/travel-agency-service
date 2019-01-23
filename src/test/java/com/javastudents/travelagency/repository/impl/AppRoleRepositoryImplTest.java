package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.AppRole;
import com.javastudents.travelagency.repository.AppRoleRepository;
import com.javastudents.travelagency.repository.CrudTest;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AppRoleRepositoryImplTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Test
    @Override
    public void createTest() {
        String name = "Test appRoleName";

        AppRole appRole = AppRole.builder()
                .name(name)
                .build();

        appRoleRepository.create(appRole);

        @Language("MySQL")
        String sql = "SELECT name from app_role where app_role_id = (select max(app_role_id) from app_role)";
        String nameDB = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(name, nameDB);
    }

    @Test
    @Override
    public void readTest() {
        String nameExpected = "appRole_1";
        AppRole byId = appRoleRepository.read(1);

        Assert.assertEquals(nameExpected, byId.getName());
    }

    @Test
    @Override
    public void updateTest() {
        String nameExpected = "New AppRole";
        AppRole appRole = appRoleRepository.read(2);
        appRole.setName(nameExpected);
        appRoleRepository.update(appRole);

        Assert.assertEquals( nameExpected, appRoleRepository.read(2).getName());
    }

    @Test
    @Override
    public void deleteTest() {
        appRoleRepository.delete(5);

        Assert.assertNull(appRoleRepository.read(5));
    }
}
