package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.AppRole;
import com.javastudents.travelagency.repository.AppRoleRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppRoleRepositoryImpl implements AppRoleRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AppRoleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void create(AppRole appRole) {
        @Language("MySQL")
        String query = "INSERT INTO app_role (name) VALUES (?)";

        jdbcTemplate.update(query, appRole.getName());
    }

    @Override
    public AppRole read(int appRoleId) {
        @Language("MySQL")
        String query = "SELECT * FROM app_role WHERE app_role_id=?";

        try {
            return jdbcTemplate.queryForObject(
                    query,
                    new Object[]{appRoleId},

                    (rs, rowNum) -> AppRole.builder()
                            .appRoleId(rs.getInt("app_role_id"))
                            .name(rs.getString("name"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(AppRole appRole) {
        @Language("MySQL")
        String query = "UPDATE app_role SET name = ? WHERE app_role_id = ?";

        jdbcTemplate.update(query, appRole.getName(), appRole.getAppRoleId());
    }

    @Override
    public void delete(int appRoleId) {
        @Language("MySQL")
        String query = "DELETE FROM app_role WHERE app_role_id = ?";

        jdbcTemplate.update(query, appRoleId);
    }

    @Override
    public List<AppRole> list() {
        @Language("MySQL")
        String query = "SELECT * FROM app_role";

        try {
            return jdbcTemplate.query(
                    query, new Object[]{},
                    (rs, rowNum) -> AppRole.builder()
                            .appRoleId(rs.getInt("app_role_id"))
                            .name(rs.getString("name"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
