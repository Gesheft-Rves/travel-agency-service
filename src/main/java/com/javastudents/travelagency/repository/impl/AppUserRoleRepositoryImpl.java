package com.javastudents.travelagency.repository.impl;


import com.javastudents.travelagency.entity.AppUserRole;
import com.javastudents.travelagency.repository.AppUserRoleRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AppUserRoleRepositoryImpl implements AppUserRoleRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AppUserRoleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void create(AppUserRole appUserRole) {
        @Language("MySQL")
        String query = "INSERT INTO app_user_role (app_user_id, role_id) VALUES (?, ?)";

        jdbcTemplate.update(
                query,
                appUserRole.getAppUserId(),
                appUserRole.getRoleId()
        );
    }

    @Override
    public AppUserRole read(int appUserRoleId) {
        @Language("MySQL")
        String query = "SELECT * FROM app_user_role WHERE app_user_role_id = ?";

        try {
            return jdbcTemplate.queryForObject(
                    query,
                    new Object[]{appUserRoleId},

                    (rs, rowNum) -> AppUserRole.builder()
                            .appUserRoleId(rs.getInt("app_user_role_id"))
                            .appUserId(rs.getInt("app_user_id"))
                            .roleId(rs.getInt("role_id"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(AppUserRole appUserRole) {
        @Language("MySQL")
        String query = "UPDATE app_user_role SET app_user_id = ?, role_id = ? WHERE app_user_role_id = ?";

        jdbcTemplate.update(
                query,
                appUserRole.getAppUserId(),
                appUserRole.getRoleId(),
                appUserRole.getAppUserRoleId()
        );
    }

    @Override
    public void delete(int appUserRoleId) {
        @Language("MySQL")
        String query = "DELETE FROM app_user_role WHERE app_user_role_id = ?";

        jdbcTemplate.update(query, appUserRoleId);
    }
}
