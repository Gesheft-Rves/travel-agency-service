package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.Customer;
import com.javastudents.travelagency.repository.CustomerRepository;
import com.javastudents.travelagency.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Customer customer) {
        repository.create(customer);
    }

    @Override
    public Customer read(int customerId) {
        return repository.read(customerId);
    }

    @Override
    public void update(Customer customer) {
        repository.update(customer);
    }

    @Override
    public void delete(int customerId) {
        repository.delete(customerId);
    }



    @Override
    public List<Customer> getCustomersByDepartmentId(int departmentId) {
        return repository.getCustomersByDepartmentId(departmentId);
    }

    @Override
    public List<Customer> getCustomersByDepartmentName(String departmentName) {
        return repository.getCustomersByDepartmentName(departmentName);
    }
}
