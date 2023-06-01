package com.example.springshiyan5.service.impl;


import com.example.springshiyan5.dao.SysPermissionDao;
import com.example.springshiyan5.entity.SysPermission;
import com.example.springshiyan5.service.SysPermissionService;
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
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    SysPermissionDao sysPermissionDao;

    @Override
    public List<SysPermission> findAll() {
        return sysPermissionDao.findAll();
    }

    @Override
    public List<SysPermission> find(SysPermission condition) {
        List<SysPermission> sysPermissionList = null;

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
                if (StringUtils.hasLength(condition.getCode())) {
                    Predicate predicate = criteriaBuilder.like(root.get("code").as(String.class), "%" + condition.getCode() + "%");
                    predicates.add(predicate);
                }
//                if (condition.getRoles() != null && condition.getRo().getId() != null) {
//                    Predicate predicate = criteriaBuilder.equal(root.get("dep").get("id").as(Integer.class), condition.getDep().getId());
//                    predicates.add(predicate);
//                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        sysPermissionList = sysPermissionDao.findAll(specification);
        return sysPermissionList;
    }


    @Override
    public Page<List<SysPermission>> findByPage(SysPermission condition, Pageable pageable) {
        Page<List<SysPermission>> sysPermissionList = null;

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
                if (StringUtils.hasLength(condition.getCode())) {
                    Predicate predicate = criteriaBuilder.like(root.get("code").as(String.class), "%" + condition.getCode() + "%");
                    predicates.add(predicate);
                }
//                if (condition.getRoles() != null && condition.getRo().getId() != null) {
//                    Predicate predicate = criteriaBuilder.equal(root.get("dep").get("id").as(Integer.class), condition.getDep().getId());
//                    predicates.add(predicate);
//                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        sysPermissionList = sysPermissionDao.findAll(specification, pageable);
        return sysPermissionList;
    }


    @Override
    public SysPermission findById(int id) {
        return sysPermissionDao.getById(id);
    }

    @Override
    public boolean add(SysPermission sysPermission) {
        return sysPermissionDao.save(sysPermission) != null;
    }

    @Override
    public boolean mod(SysPermission sysPermission) {
        return sysPermissionDao.save(sysPermission) != null;
    }

    @Override
    public void del(int id) {
        sysPermissionDao.deleteById(id);
    }
}
