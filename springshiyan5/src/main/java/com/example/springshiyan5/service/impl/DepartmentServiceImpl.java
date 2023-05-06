package com.example.springshiyan5.service.impl;

import com.example.springshiyan5.dao.DepartmentDao;
import com.example.springshiyan5.dao.EmployeeDao;
import com.example.springshiyan5.entity.Department;
import com.example.springshiyan5.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    DepartmentDao departmentDao;
    @Resource
    EmployeeDao employeeDao;

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public List<Department> find(Department condition) {
        return departmentDao.find(condition);
    }

    @Override
    public Department findById(int id) {
        return departmentDao.findById(id);
    }

    @Override
    public boolean add(Department department) {
        return departmentDao.add(department)==1?true:false;
    }

    @Override
    public boolean mod(Department department) {
        return departmentDao.mod(department)==1?true:false;
    }

    @Override
    public boolean del(int id) {
        if (departmentDao.del(id)==1){
            employeeDao.modByDep(id);
            return true;
        }
        return false;
    }
}
