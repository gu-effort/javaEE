package com.example.springshiyan5.dao;

import com.example.springshiyan5.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer>, JpaSpecificationExecutor<Department> {
}
