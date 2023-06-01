package com.example.springshiyan5.service;

import com.example.springshiyan5.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    List<Employee> find(Employee condition);

    Page<List<Employee>> findByPage(Employee condition, Pageable pageable);

    Employee findById(int id);

//    boolean add(Employee employee);
//
//    boolean mod(Employee employee);

    boolean save(Employee employee);

    void del(int id);

}
