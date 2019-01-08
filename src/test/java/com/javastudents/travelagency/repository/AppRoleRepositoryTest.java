package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.AppRole;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AppRoleRepositoryTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AppRoleRepository repository;

    @Test
    @Override
    public void createTest() {
        String appRoleName = "Test appRoleName";

        AppRole appRole = AppRole.builder()
                .name(appRoleName)
                .build();

        repository.create(appRole);

        @Language("MySQL")
        String sql = "SELECT name from app_role where app_role_id = (select max(app_role_id) from app_role)";
        String nameFromDb = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(appRoleName, nameFromDb);
    }

    @Test
    @Override
    public void readTest() {
        String expected = "appRole_1";

        AppRole byId = repository.read(1);

        Assert.assertEquals(expected, byId.getName());
    }

    @Test
    @Override
    public void updateTest() {
        String expectedValue = "New AppRole";
        AppRole appRole = repository.read(2);
        appRole.setName(expectedValue);
        repository.update(appRole);

        Assert.assertEquals( expectedValue, repository.read(2).getName());

    }

    @Test
    @Override
    public void deleteTest() {

        repository.delete(5);

        Assert.assertNull(repository.read(5));
    }
}
