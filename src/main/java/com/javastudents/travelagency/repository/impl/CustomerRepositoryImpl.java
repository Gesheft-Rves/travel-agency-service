package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.entity.Customer;
import com.javastudents.travelagency.repository.CustomerRepository;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Customer customer) {

        @Language("MySQL")
        String query = "INSERT INTO customer (department_id, name) VALUES (?, ?)";

        jdbcTemplate.update(
                query,
                customer.getDepartmentId(),
                customer.getName()
        );
    }

    @Override
    public void update(Customer customer) {
        @Language("MySQL")
        String query = "UPDATE customer SET department_id=?, name=?";

        jdbcTemplate.update(
                query,
                customer.getDepartmentId(),
                customer.getName()
        );
    }

    @Override
    public void delete(int customerId) {
        @Language("MySQL")
        String query = "DELETE FROM customer WHERE customer_id = ?";

        jdbcTemplate.update(
                query, customerId
        );
    }

    @Override
    public Customer read(int customerId) {
        @Language("MySQL")
        String query = "SELECT * FROM customer WHERE customer_id = ?";

        try {
            return jdbcTemplate.queryForObject(query, new Object[]{customerId},
                    (rs, rowNum) -> Customer.builder()
                            .id(rs.getInt("customer_id"))
                            .departmentId(rs.getInt("department_id"))
                            .name(rs.getString("name"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    @Override
    public List<Customer> getCustomersByDepartmentId(int departmentId) {
        @Language("MySQL")
        String query = "SELECT * FROM   customer WHERE department_id = ?";

        try {
            return jdbcTemplate.query(
                    query, new Object[]{departmentId},
                    (rs, rowNum) -> Customer.builder()
                            .id(rs.getInt("customer_id"))
                            .departmentId(rs.getInt("department_id"))
                            .name(rs.getString("name"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Customer> getCustomersByDepartmentName(String departmentName) {
        @Language("MySQL")
        String query = "SELECT * FROM   customer " +
                "JOIN department ON customer.department_id = department.department_id " +
                "WHERE department.name = ?";

        try {
            return jdbcTemplate.query(query, new Object[]{departmentName},
                    (rs, rowNum) -> Customer.builder()
                            .id(rs.getInt("customer_id"))
                            .departmentId(rs.getInt("department_id"))
                            .name(rs.getString("name"))
                            .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
