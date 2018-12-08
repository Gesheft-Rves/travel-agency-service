package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer> {

    List<Customer> getCustomersByDepartmentId(int departmentId);

    List<Customer> getCustomersByDepartmentName(String departmentName);
}
