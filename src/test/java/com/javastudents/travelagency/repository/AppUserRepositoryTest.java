package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.AppUser;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


public class AppUserRepositoryTest extends AbstractTest implements CrudTest{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AppUserRepository appUserRepository;

    @Test
    @Override
    public void createTest() {
        String appUserName = "New appUserName";
        Integer travelAgentId = 5;

        AppUser appUser = AppUser.builder()
                .name(appUserName)
                .surname("newAppUserSurname")
                .email("newAppUserEmail")
                .login("newAppUserLogin")
                .password("newAppUserPass")
                .travelAgentId(travelAgentId)
                .build();

        appUserRepository.create(appUser);

        @Language("MySQL")
        String sql = "SELECT name from app_user where app_user_id = (select max(app_user_id) from app_user)";
        String nameFromDb = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(appUserName, nameFromDb);

    }

    @Test
    @Override
    public void readTest() {
        String expected = "app_user_name_1";
        AppUser byId = appUserRepository.read(1);

        Assert.assertEquals(expected, byId.getName());
    }

    @Test
    @Override
    public void updateTest() {
        String expectedValue = "New appUser";
        AppUser appUser = appUserRepository.read(2);
        appUser.setName(expectedValue);
        appUserRepository.update(appUser);

        Assert.assertEquals(expectedValue, appUserRepository.read(2).getName());
    }

    @Test
    @Override
    public void deleteTest() {

        appUserRepository.delete(1);

        Assert.assertNull(appUserRepository.read(1));
    }
}
