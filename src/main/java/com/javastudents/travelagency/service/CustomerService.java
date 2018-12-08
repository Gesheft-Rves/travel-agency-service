package com.javastudents.travelagency.service;


import com.javastudents.travelagency.entity.Customer;

import java.util.List;

public interface CustomerService extends CrudService<Customer> {

    List<Customer> getCustomersByDepartmentId(int departmentId);

    List<Customer> getCustomersByDepartmentName(String departmentName);

}
