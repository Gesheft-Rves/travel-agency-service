package com.javastudents.travelagency.repository.impl;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.Customer;
import com.javastudents.travelagency.repository.CrudTest;
import com.javastudents.travelagency.repository.CustomerRepository;
import com.javastudents.travelagency.repository.DepartmentRepository;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CustomerRepositoryImplTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    @Override
    public void createTest() {
        String customerName = "Test Customer";
        Customer customer = Customer.builder()
                .name(customerName)
                .build();
        repository.create(customer);

        @Language("MySQL")
        String sql = "SELECT name FROM customer WHERE customer_id = (SELECT max(customer_id) FROM customer)";
        String nameFromDb = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(customerName, nameFromDb);

    }


    @Test
    @Override
    public void readTest() {
        Customer byName = repository.read(1);

        String expected = "Jack";

        Assert.assertEquals(expected, byName.getName());

    }

    @Test
    @Override
    public void updateTest() {
        Customer customerOld = repository.read(2);
        Assert.assertEquals("Piter1", customerOld.getName());

        Customer customer = repository.read(2);
        customer.setName("Piter New");
        repository.update(customer);
        customer = repository.read(2);

        Assert.assertEquals(customerOld.getId(), customer.getId());
        Assert.assertNotEquals(customer.getName(), customerOld.getName());
    }


    @Test
    @Override
    public void deleteTest() {
        @Language("MySQL")
        String sql = "select max(customer_id) from customer";
        int maxId = jdbcTemplate.queryForObject(sql, Integer.class);

        repository.delete(maxId);

        Assert.assertNull(repository.read(maxId));
    }


    @Test
    public void getCustomersByDepartmentIdTest() {

        @Language("MySQL")
        String sql = "SELECT COUNT(*) FROM   customer WHERE department_id = 2";

        int count = jdbcTemplate.queryForObject(sql, Integer.class);

        List<Customer> list = repository.getCustomersByDepartmentId(2);
        Assert.assertNotNull(list);
        Assert.assertEquals(count, list.size());
        for (Customer cust: list) {
            Assert.assertEquals("East", departmentRepository.read(cust.getDepartmentId()).getName());
        }

    }

    @Test
    public void getCustomersByDepartmentName(){

        @Language("MySQL")
        String sql = "SELECT COUNT(*) FROM   customer WHERE department_id = 2";

        int count = jdbcTemplate.queryForObject(sql, Integer.class);

        List<Customer> list = repository.getCustomersByDepartmentName("East");
        Assert.assertNotNull(list);
        Assert.assertEquals(count, list.size());
        for (Customer cust: list) {
            Assert.assertEquals("East", departmentRepository.read(cust.getDepartmentId()).getName());
        }
    }
}
