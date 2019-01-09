package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.AppPermission;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AppPermissionRepositoryImplTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AppPermissionRepository appPermissionRepository;

    @Test
    @Override
    public void createTest() {
        String name = "Test appPermission";

        AppPermission appPermission = AppPermission.builder()
                .name(name)
                .build();

        appPermissionRepository.create(appPermission);

        @Language("MySQL")
        String sql = "SELECT name from app_permission where app_permission_id = (select max(app_permission_id) from app_permission)";
        String nameDB = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(name, nameDB);
    }

    @Test
    @Override
    public void readTest() {
        String nameExpected = "permission_1";
        AppPermission byId = appPermissionRepository.read(1);

        Assert.assertEquals(nameExpected, byId.getName());
    }

    @Test
    @Override
    public void updateTest() {
        String nameExpected = "NewPermission";
        AppPermission appPermission = appPermissionRepository.read(2);
        appPermission.setName(nameExpected);
        appPermissionRepository.update(appPermission);

        Assert.assertEquals(nameExpected, appPermissionRepository.read(2).getName());
    }

    @Test
    @Override
    public void deleteTest() {
        appPermissionRepository.delete(4);

        Assert.assertNull(appPermissionRepository.read(4));
    }
}
