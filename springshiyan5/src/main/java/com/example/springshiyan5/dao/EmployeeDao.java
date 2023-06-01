package com.example.springshiyan5.dao;

import com.example.springshiyan5.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {

    @Modifying
    @Query("update Employee e set e.dep=null where e.dep.id=:depId")
    void modByDep(Integer depId);
}
