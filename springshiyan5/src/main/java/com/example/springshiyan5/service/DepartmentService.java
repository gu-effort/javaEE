package com.example.springshiyan5.service;

import com.example.springshiyan5.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DepartmentService {

    List<Department> findAll();

    List<Department> find(Department condition);

    Page<List<Department>> findByPage(Department condition, Pageable pageable);

    Department findById(int id);

    boolean add(Department department);

    boolean mod(Department department);


    void del(int id);

}
