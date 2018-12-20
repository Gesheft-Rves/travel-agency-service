package com.javastudents.travelagency.repository.impl;


import com.javastudents.travelagency.entity.AppRolePermission;
import com.javastudents.travelagency.repository.AppRolePermissionRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

        jdbcTemplate.update(query, appRolePermission.getAppRoleId(),appRolePermission.getAppRolePermissionId());
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

    // TODO: только udate roleId
    @Override
    public void update(AppRolePermission appRolePermission) {
        @Language("MySQL")
        String query = "UPDATE app_role_permission SET  app_role_id = ?  WHERE app_role_permission_id = ?";

        jdbcTemplate.update(query, appRolePermission.getAppRoleId(), appRolePermission.getAppRolePermissionId());
    }

    @Override
    public void delete(int appRolePermissionId) {
        @Language("MySQL")
        String query = "DELETE FROM app_role_permission WHERE app_role_permission_id = ?";

        jdbcTemplate.update(query, appRolePermissionId);
    }
}
