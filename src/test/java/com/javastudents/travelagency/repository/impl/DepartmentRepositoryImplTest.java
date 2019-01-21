package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.Department;
import com.javastudents.travelagency.repository.CrudTest;
import com.javastudents.travelagency.repository.DepartmentRepository;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DepartmentRepositoryImplTest extends AbstractTest implements CrudTest {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DepartmentRepository repository;



    @Test
    @Override
    public void createTest() {
        String departmentName = "Test Department";

        Department department = Department.builder()
                .name(departmentName)
                .build();

        repository.create(department);

        @Language("MySQL")
        String sql = "SELECT name FROM department WHERE department_id = (SELECT MAX(department_id) FROM department)";

        String nameFromDb = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(departmentName, nameFromDb);

    }

    @Test
    @Override
    public void readTest() {
        Department byName = repository.read("West");

        int id = byName.getId();

        Department byId = repository.read(id);


        Assert.assertNotNull(byId);
        Assert.assertNotNull(byName);
        Assert.assertEquals(byName, byId);

    }

    @Test
    @Override
    public void updateTest() {
        Department west = repository.read("West");

        west.setName("West New");

        repository.update(west);

        Department westNew = repository.read("West New");

        Assert.assertNotNull(westNew);
        Assert.assertEquals(west.getId(), westNew.getId());
    }

    @Test
    @Override
    public void deleteTest() {
        Department south = repository.read("South");

        repository.delete(south.getName());

        Assert.assertNull(repository.read("South"));
    }
}
