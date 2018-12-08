package com.javastudents.travelagency.service;


import com.javastudents.travelagency.entity.Department;

public interface DepartmentService extends CrudService<Department>{

    void delete(String departmentName);

    Department read(String departmentName);
}
