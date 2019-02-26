package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.AppPermission;
import com.javastudents.travelagency.repository.AppPermissionRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppPermissionRepositoryImpl implements AppPermissionRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AppPermissionRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(AppPermission appPermission) {
        @Language("MySQL")
        String query = "INSERT INTO app_permission (name) VALUES (?)";

        jdbcTemplate.update(query, appPermission.getName());
    }

    @Override
    public AppPermission read(int appPermissionId) {
        @Language("MySQL")
        String query = "SELECT * FROM app_permission WHERE app_permission_id=?";

        try {
            return jdbcTemplate.queryForObject(
                    query,
                    new Object[]{appPermissionId},

                    (rs, rowNum) -> AppPermission.builder()
                            .appPermissionId(rs.getInt("app_permission_id"))
                            .name(rs.getString("name"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(AppPermission appPermission) {
        @Language("MySQL")
        String query = "UPDATE app_permission SET name = ? WHERE app_permission_id = ?";

        jdbcTemplate.update(query, appPermission.getName(), appPermission.getAppPermissionId());
    }

    @Override
    public void delete(int appPermissionId) {
        @Language("MySQL")
        String query = "DELETE FROM app_permission WHERE app_permission_id = ?";

        jdbcTemplate.update(query, appPermissionId);
    }

    @Override
    public List<AppPermission> list() {
        @Language("MySQL")
        String query = "SELECT * FROM app_permission";

        try {
            return jdbcTemplate.query(
                    query, new Object[]{},
                    (rs, rowNum) -> AppPermission.builder()
                            .appPermissionId(rs.getInt("app_permission_id"))
                            .name(rs.getString("name"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
