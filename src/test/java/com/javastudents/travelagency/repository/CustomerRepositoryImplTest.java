package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.Customer;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

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

        String name = "West";

        Assert.assertNotNull(byName);
        Assert.assertEquals(name, byName.getName());

    }

    @Test
    @Override
    public void updateTest() {
        Customer west = repository.read(2);

        west.setName("West New");

        repository.update(west);

        Customer westNew = repository.read(2);

        Assert.assertNotNull(westNew);
        Assert.assertEquals(west.getId(), westNew.getId());
    }


    @Test
    @Override
    public void deleteTest() {
        Customer south = repository.read(3);

        repository.delete(3);

        Assert.assertNull(repository.read(3));
    }
}
