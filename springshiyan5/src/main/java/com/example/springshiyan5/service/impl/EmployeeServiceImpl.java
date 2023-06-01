package com.example.springshiyan5.service.impl;


import com.example.springshiyan5.dao.EmployeeDao;
import com.example.springshiyan5.entity.Employee;
import com.example.springshiyan5.service.EmployeeService;
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
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public List<Employee> find(Employee condition) {
        List<Employee> employeeList = null;

        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (condition.getId() != null) {
                    Predicate predicate = criteriaBuilder.equal(root.get("id").as(Integer.class), condition.getId());
                    predicates.add(predicate);
                }
                if (StringUtils.hasLength(condition.getName())) {
                    Predicate predicate = criteriaBuilder.like(root.get("name").as(String.class), "%" + condition.getName() + "%");
                    predicates.add(predicate);
                }
                if (StringUtils.hasLength(condition.getGender())) {
                    Predicate predicate = criteriaBuilder.like(root.get("gender").as(String.class), "%" + condition.getGender() + "%");
                    predicates.add(predicate);
                }
                if (condition.getNumber() != null) {
                    Predicate predicate = criteriaBuilder.equal(root.get("number").as(Integer.class), condition.getNumber());
                    predicates.add(predicate);
                }
                if (condition.getAge() != null) {
                    Predicate predicate = criteriaBuilder.equal(root.get("age").as(Integer.class), condition.getAge());
                    predicates.add(predicate);
                }
                if (condition.getDep() != null && condition.getDep().getId() != null) {
                    Predicate predicate = criteriaBuilder.equal(root.get("dep").get("id").as(Integer.class), condition.getDep().getId());
                    predicates.add(predicate);
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
        employeeList = employeeDao.findAll(specification);

        return employeeList;
    }

    @Override
    public Page<List<Employee>> findByPage(Employee condition, Pageable pageable) {
        Page<List<Employee>> employeeList = null;

        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (condition.getId() != null) {
                    Predicate predicate = criteriaBuilder.equal(root.get("id").as(Integer.class), condition.getId());
                    predicates.add(predicate);
                }
                if (StringUtils.hasLength(condition.getName())) {
                    Predicate predicate = criteriaBuilder.like(root.get("name").as(String.class), "%" + condition.getName() + "%");
                    predicates.add(predicate);
                }
                if (StringUtils.hasLength(condition.getGender())) {
                    Predicate predicate = criteriaBuilder.like(root.get("gender").as(String.class), "%" + condition.getGender() + "%");
                    predicates.add(predicate);
                }
                if (condition.getNumber() != null) {
                    Predicate predicate = criteriaBuilder.equal(root.get("number").as(Integer.class), condition.getNumber());
                    predicates.add(predicate);
                }
                if (condition.getAge() != null) {
                    Predicate predicate = criteriaBuilder.equal(root.get("age").as(Integer.class), condition.getAge());
                    predicates.add(predicate);
                }
                if (condition.getDep() != null && condition.getDep().getId() != null) {
                    Predicate predicate = criteriaBuilder.equal(root.get("dep").get("id").as(Integer.class), condition.getDep().getId());
                    predicates.add(predicate);
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
        employeeList = employeeDao.findAll(specification, pageable);

        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.getById(id);
    }

//    @Override
//    public boolean add(Employee employee) {
//        employeeDao.save(employee);
//        return true;
//    }
//
//    @Override
//    public boolean mod(Employee employee) {
//        employeeDao.save(employee);
//        return true;
//    }


    @Override
    public boolean save(Employee employee) {
        employeeDao.save(employee);
        return true;
    }

    @Override
    public void del(int id) {
        employeeDao.deleteById(id);
    }
}
