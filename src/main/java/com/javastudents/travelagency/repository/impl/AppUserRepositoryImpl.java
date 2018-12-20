package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.AppUser;
import com.javastudents.travelagency.repository.AppUserRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AppUserRepositoryImpl implements AppUserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AppUserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(AppUser appUser) {
        @Language("MySQL")
        String query = "INSERT INTO app_user (name, surname, email, login, password, travel_agent_id) VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                query,
                appUser.getName(),
                appUser.getSurname(),
                appUser.getEmail(),
                appUser.getLogin(),
                appUser.getPassword(),
                appUser.getTravelAgentId()
        );
    }

    @Override
    public AppUser read(int appUserId) {
        @Language("MySQL")
        String query = "SELECT * FROM app_user WHERE app_user_id = ?";

        try {
            return jdbcTemplate.queryForObject(
                    query,
                    new Object[]{appUserId},

                    (rs, rowNum) -> AppUser.builder()
                            .appUserId(rs.getInt("app_user_id"))
                            .name(rs.getString("name"))
                            .surname(rs.getString("surname"))
                            .email(rs.getString("email"))
                            .login(rs.getString("login"))
                            .password(rs.getString("password"))
                            .travelAgentId(rs.getInt("travel_agent_id"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(AppUser appUser) {
        @Language("MySQL")
        String query = "UPDATE app_user SET name = ?, surname = ?, email = ?, login = ?, password = ?, travel_agent_id = ? WHERE app_user_id = ?";

        jdbcTemplate.update(
                query,
                appUser.getName(),
                appUser.getSurname(),
                appUser.getEmail(),
                appUser.getLogin(),
                appUser.getPassword(),
                appUser.getTravelAgentId()

        );
    }

    @Override
    public void delete(int appUserId) {
        @Language("MySQL")
        String query = "DELETE FROM app_user WHERE app_user_id = ?";

        jdbcTemplate.update(query, appUserId);
    }
}
