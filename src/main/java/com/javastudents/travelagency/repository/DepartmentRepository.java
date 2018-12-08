package com.javastudents.travelagency.repository;


import com.javastudents.travelagency.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department> {

    void delete(String departmentName);

    Department read(String departmentName);
}
