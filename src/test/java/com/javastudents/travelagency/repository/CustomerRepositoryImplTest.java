package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.Customer;
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



    @Test
    @Override
    public void createTest() {
        String customerName = "Test Customer";
        Customer customer = Customer.builder()
                .name(customerName)
                .build();
        repository.create(customer);

        @Language("MySQL")
        String sql = "SELECT name from customer where customer_id = (select max(customer_id) from customer)";
        String nameFromDb = jdbcTemplate.queryForObject(sql, String.class);

        Assert.assertEquals(customerName, nameFromDb);

    }


    @Test
    @Override
    public void readTest() {
        Customer byName = repository.read(1);

        String name = "Jack";

        Assert.assertNotNull(byName);
        Assert.assertEquals(name, byName.getName());

    }

    @Test
    @Override
    public void updateTest() {
        Customer customerOld = repository.read(2);
        Customer customer = repository.read(2);

        Assert.assertEquals("Piter", customer.getName());

        customer.setName("Piter New");

        repository.update(customer);

        Assert.assertNotNull(customer);
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

        Customer customer = repository.read(2);

        int depart = customer.getDepartmentId();

        @Language("MySQL")
        String sql = "SELECT COUNT(*) FROM   customer WHERE department_id = 2";

        int in = jdbcTemplate.queryForObject(sql, Integer.class);

        List list = repository.getCustomersByDepartmentId(2);

        Assert.assertEquals(in, list.size());
    }

    @Test
    public void getCustomersByDepartmentName(){
        @Language("MySQL")
        String sql = "SELECT COUNT(*) FROM   customer WHERE department_id = 2";

        int in = jdbcTemplate.queryForObject(sql, Integer.class);

        List list = repository.getCustomersByDepartmentName("East");

        Assert.assertEquals(in, list.size());
    }
}
