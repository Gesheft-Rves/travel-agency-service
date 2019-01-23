package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.AppUser;
import com.javastudents.travelagency.repository.AppUserRepository;
import com.javastudents.travelagency.repository.CrudTest;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


public class AppUserRepositoryImplTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AppUserRepository appUserRepository;

    @Test
    @Override
    public void createTest() {
        String name = "New appUserName";
        Integer travelAgentId = 5;

        AppUser appUser = AppUser.builder()
                .name(name)
                .surname("newAppUserSurname")
                .email("newAppUserEmail")
                .login("newAppUserLogin")
                .password("newAppUserPass")
                .travelAgentId(travelAgentId)
                .build();

        appUserRepository.create(appUser);

        @Language("MySQL")
        String sql = "SELECT name from app_user where app_user_id = (select max(app_user_id) from app_user)";
        String nameDB = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(name, nameDB);

    }

    @Test
    @Override
    public void readTest() {
        String nameExpected = "app_user_name_1";
        AppUser byId = appUserRepository.read(1);

        Assert.assertEquals(nameExpected, byId.getName());
    }

    @Test
    @Override
    public void updateTest() {
        String nameExpected = "New appUser";
        AppUser appUser = appUserRepository.read(2);
        appUser.setName(nameExpected);
        appUserRepository.update(appUser);

        Assert.assertEquals(nameExpected, appUserRepository.read(2).getName());
    }

    @Test
    @Override
    public void deleteTest() {
        appUserRepository.delete(1);

        Assert.assertNull(appUserRepository.read(1));
    }
}
