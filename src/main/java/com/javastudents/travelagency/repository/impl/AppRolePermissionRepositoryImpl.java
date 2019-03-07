package com.javastudents.travelagency.repository.impl;


import com.javastudents.travelagency.entity.AppPermission;
import com.javastudents.travelagency.entity.AppRole;
import com.javastudents.travelagency.entity.AppRolePermission;
import com.javastudents.travelagency.entity.wrapper.AppRolePermissionWrapper;
import com.javastudents.travelagency.repository.AppRolePermissionRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppRolePermissionRepositoryImpl implements AppRolePermissionRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AppRolePermissionRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(AppRolePermission appRolePermission) {
        @Language("MySQL")
        String query = "INSERT INTO app_role_permission (app_role_id, app_permission_id) VALUES (?,?)";

        jdbcTemplate.update(query, appRolePermission.getAppRoleId(),appRolePermission.getAppPermissionId());
    }

    @Override
    public AppRolePermission read(int appRolePermissionId) {
        @Language("MySQL")
        String query = "SELECT * FROM app_role_permission WHERE app_role_permission_id=?";

        try {
            return jdbcTemplate.queryForObject(
                    query,
                    new Object[]{appRolePermissionId},

                    (rs, rowNum) -> AppRolePermission.builder()
                            .appRolePermissionId(rs.getInt("app_role_permission_id"))
                            .appRoleId(rs.getInt("app_role_id"))
                            .appPermissionId(rs.getInt("app_permission_id"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(AppRolePermission appRolePermission) {
        @Language("MySQL")
        String query = "UPDATE app_role_permission SET app_role_id = ?, app_permission_id = ?  WHERE app_role_permission_id = ?";

        jdbcTemplate.update(query, appRolePermission.getAppRoleId(),appRolePermission.getAppPermissionId(), appRolePermission.getAppRolePermissionId());
    }

    @Override
    public void delete(int appRolePermissionId) {
        @Language("MySQL")
        String query = "DELETE FROM app_role_permission WHERE app_role_permission_id = ?";

        jdbcTemplate.update(query, appRolePermissionId);
    }

    @Override
    public List<AppRolePermission> list() {
        @Language("MySQL")
        String query = "SELECT * FROM app_role_permission";

        try {
            return jdbcTemplate.query(
                    query, new Object[]{},
                    (rs, rowNum) -> AppRolePermission.builder()
                            .appRolePermissionId(rs.getInt("app_role_permission_id"))
                            .appRoleId(rs.getInt("app_role_id"))
                            .appPermissionId(rs.getInt("app_permission_id"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<AppRolePermissionWrapper> appRolePermissionWrapperList() {
        @Language("MySQL")
        String query = "SELECT *," +
                "       app_permission.name as permission_name,\n" +
                "       app_role.name as role_name\n" +
                "FROM app_role_permission\n" +
                "JOIN app_role on app_role_permission.app_role_id = app_role.app_role_id\n" +
                "JOIN app_permission on app_role_permission.app_permission_id = app_permission.app_permission_id";

        try {
            return jdbcTemplate.query(
                    query, new Object[]{},
                    (rs, rowNum) -> AppRolePermissionWrapper.builder()
                            .appRolePermissionId(rs.getInt("app_role_permission_id"))

                            .appRole(AppRole.builder()
                                        .appRoleId(rs.getInt("app_role_id"))
                                        .name(rs.getString("role_name"))
                                        .build())

                            .appPermission(AppPermission.builder()
                                        .appPermissionId (rs.getInt("app_permission_id"))
                                        .name(rs.getString("permission_name"))
                                        .build())
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public AppRolePermissionWrapper readAppRolePermissionWrapper(Integer appRolePermissionId) {
        @Language("MySQL")
        String query = "SELECT *," +
                "       app_permission.name as permission_name,\n" +
                "       app_role.name as role_name\n" +
                "FROM app_role_permission\n" +
                "JOIN app_role on app_role_permission.app_role_id = app_role.app_role_id\n" +
                "JOIN app_permission on app_role_permission.app_permission_id = app_permission.app_permission_id\n"+
                "WHERE app_role_permission_id=?";

        try {
            return jdbcTemplate.queryForObject(
                    query, new Object[]{appRolePermissionId},
                    (rs, rowNum) -> AppRolePermissionWrapper.builder()
                            .appRolePermissionId(rs.getInt("app_role_permission_id"))
                            .appRole(AppRole.builder()
                                    .appRoleId(rs.getInt("app_role_id"))
                                    .name(rs.getString("role_name"))
                                    .build())
                            .appPermission(AppPermission.builder()
                                    .appPermissionId (rs.getInt("app_permission_id"))
                                    .name(rs.getString("permission_name"))
                                    .build())
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
