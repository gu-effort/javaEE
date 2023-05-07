package cdu.gu.service.impl;

import cdu.gu.dao.DepartmentDao;
import cdu.gu.dao.EmployeeDao;
import cdu.gu.entity.Department;
import cdu.gu.service.DepartmentService;
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
