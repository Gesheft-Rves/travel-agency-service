package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.AbstractTest;
import com.javastudents.travelagency.entity.Customer;
import org.intellij.lang.annotations.Language;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CustomerRepositoryTest extends AbstractTest implements CrudTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    @Override
    public void createTest() {
        Customer customer = Customer.builder().name("CustomerTest").build();
        repository.create(customer);

        @Language("MySQL")
        String sql = "SELECT name from customer where customer_id = (select max(customer_id)from customer)";
        String nameFromDb = jdbcTemplate.queryForObject(sql,String.class);
        Assert.assertEquals(customer.getName(),nameFromDb);
    }

    @Test
    @Override
    public void readTest() {
        Customer customer = repository.read(1);
        String fromDb = customer.getName();
        String s = "Test";

        Assert.assertEquals(fromDb,s);
    }

    @Test
    @Override
    public void updateTest() {
        @Language("MySQL")
        String query = "UPDATE customer SET name = ? WHERE customer_id = ?";
        jdbcTemplate.update(query, "NewNameCustomer", 1);

        String fromDb = repository.read(1).getName();
        String s = "NewNameCustomer";

        Assert.assertEquals(fromDb,s);
    }

    @Test
    @Override
    public void deleteTest() {
        @Language("MySQL")
        String query = "DELETE FROM customer WHERE customer_id = ?";
        jdbcTemplate.update(query, 1);

        Assert.assertNull(repository.read(1));
    }

    @Test
    public void getCustomersByDepartmentIdTest(){
        List<Customer> customers = repository.getCustomersByDepartmentId(1);
        Assert.assertNotNull(customers);
        Assert.assertEquals(2,customers.size());
        for (Customer current :customers) {
            int k = current.getDepartmentId();
            Assert.assertEquals(1, k);
        }
    }

    @Test
    public void getCustomersByDepartmentNameTest(){
        List<Customer> customers = repository.getCustomersByDepartmentName("East");
        Assert.assertNotNull(customers);
        Assert.assertEquals(2,customers.size());
        for (Customer current :customers) {
            Assert.assertEquals("East", departmentRepository.read(current.getDepartmentId()).getName());
        }
    }
}
