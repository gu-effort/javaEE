package com.example.springshiyan5.service.impl;

import com.example.springshiyan5.dao.DepartmentDao;
import com.example.springshiyan5.dao.EmployeeDao;
import com.example.springshiyan5.entity.Department;
import com.example.springshiyan5.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    EmployeeDao employeeDao;

    @Override
    public Page<List<Department>> findByPage(Department condition, Pageable pageable) {
        Page<List<Department>> departmentList = null;

        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (condition.getNumber() != null) {
                    Predicate predicate = criteriaBuilder.equal(root.get("number").as(Integer.class), condition.getNumber());
                    predicates.add(predicate);
                }
                if (StringUtils.hasLength(condition.getName())) {
                    Predicate predicate = criteriaBuilder.like(root.get("name").as(String.class), "%" + condition.getName() + "%");
                    predicates.add(predicate);
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
        departmentList = departmentDao.findAll(specification, pageable);

        return departmentList;
    }

    @Override
    public List<Department> find(Department condition) {
        List<Department> departmentList = null;

        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (condition.getNumber() != null) {
                    Predicate predicate = criteriaBuilder.equal(root.get("number").as(Integer.class), condition.getNumber());
                    predicates.add(predicate);
                }
                if (StringUtils.hasLength(condition.getName())) {
                    Predicate predicate = criteriaBuilder.like(root.get("name").as(String.class), "%" + condition.getName() + "%");
                    predicates.add(predicate);
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
        departmentList = departmentDao.findAll(specification);

        return departmentList;
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public Department findById(int id) {
        return departmentDao.getById(id);
    }

    @Override
    public boolean add(Department department) {
        departmentDao.save(department);
        return true;
    }

    @Override
    public boolean mod(Department department) {
        departmentDao.save(department);
        return true;
    }

    @Override
    public void del(int id) {
        departmentDao.deleteById(id);
        employeeDao.modByDep(id);
    }

}
