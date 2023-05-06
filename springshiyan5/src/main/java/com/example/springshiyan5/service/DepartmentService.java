package com.example.springshiyan5.service;

import com.example.springshiyan5.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();
    List<Department> find(Department condition);
    Department findById(int id);
    boolean add(Department department);
    boolean mod(Department department);
    boolean del(int id);
}
