package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.AppPermission;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AppPermissionRepositoryTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AppPermissionRepository repository;

    @Test
    @Override
    public void createTest() {
        String appPermissionName = "Test appPermission";

        AppPermission appPermission = AppPermission.builder()
                .name(appPermissionName)
                .build();

        repository.create(appPermission);

        @Language("MySQL")
        String sql = "SELECT name from app_permission where app_permission_id = (select max(app_permission_id) from app_permission)";

        String nameFromDb = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(appPermissionName, nameFromDb);
    }

    @Test
    @Override
    public void readTest() {
        String expected = "permission_1";

        AppPermission byId = repository.read(1);
        Assert.assertNotNull(byId);
        Assert.assertEquals(expected, byId.getName());
    }

    @Test
    @Override
    public void updateTest() {
        AppPermission appPermission = repository.read(2);
        appPermission.setName("NewPermission");
        repository.update(appPermission);

        AppPermission newPermission = repository.read(2);

        Assert.assertNotNull(newPermission);
        Assert.assertEquals(appPermission.getAppPermissionId(), newPermission.getAppPermissionId());
    }

    @Test
    @Override
    public void deleteTest() {

        repository.delete(4);

        Assert.assertNull(repository.read(4));
    }
}
