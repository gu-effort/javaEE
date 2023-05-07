package cdu.gu.dao;

import cdu.gu.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao {
    Employee findById(int id);
    List<Employee> find(Employee condition);
    int add(Employee employee);
    int mod(Employee employee);
    int del(int id);
    int modByDep(int depId);
}
