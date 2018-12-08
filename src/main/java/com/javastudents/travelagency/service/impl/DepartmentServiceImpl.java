package com.javastudents.travelagency.service.impl;

import com.javastudents.travelagency.entity.Department;
import com.javastudents.travelagency.repository.DepartmentRepository;
import com.javastudents.travelagency.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Department department) {
        repository.create(department);
    }

    @Override
    public Department read(int departmentId) {
        return repository.read(departmentId);
    }

    @Override
    public void update(Department department) {
        repository.update(department);
    }

    @Override
    public void delete(int departmentId) {
        repository.delete(departmentId);
    }

    @Override
    public void delete(String departmentName) {
        repository.delete(departmentName);
    }

    @Override
    public Department read(String departmentName) {
        return repository.read(departmentName);
    }
}
