package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.Department;
import com.javastudents.travelagency.repository.DepartmentRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DepartmentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Department department) {
        @Language("MySQL")
        String query = "INSERT INTO department (name) VALUES (?)";

        jdbcTemplate.update(query, department.getName());
    }

    @Override
    public void update(Department department) {
        @Language("MySQL")
        String query = "UPDATE department SET name = ? WHERE department_id = ?";

        jdbcTemplate.update(query, department.getName(), department.getId());
    }

    @Override
    public void delete(int departmentId) {
        @Language("MySQL")
        String query = "DELETE FROM department WHERE department_id = ?";

        jdbcTemplate.update(query, departmentId);
    }

    @Override
    public void delete(String departmentName) {
        @Language("MySQL")
        String query = "DELETE FROM department WHERE name = ?";

        jdbcTemplate.update(query, departmentName);
    }

    @Override
    public Department read(int departmentId) {
        @Language("MySQL")
        String query = "SELECT * FROM department WHERE department_id=?";

        try {
            return jdbcTemplate.queryForObject(
                    query,
                    new Object[]{departmentId},

                    (rs, rowNum) -> Department.builder()
                            .id(rs.getInt("department_id"))
                            .name(rs.getString("name"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Department read(String departmentName) {
        @Language("MySQL")
        String query = "SELECT * FROM department WHERE name=?";

        try {
            return jdbcTemplate.queryForObject(
                    query,
                    new Object[]{departmentName},
                    (rs, rowNum) -> Department.builder()
                            .id(rs.getInt("department_id"))
                            .name(rs.getString("name"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
