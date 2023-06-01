package com.example.springshiyan5.service.impl;


import com.example.springshiyan5.dao.SysRoleDao;
import com.example.springshiyan5.entity.SysRole;
import com.example.springshiyan5.service.SysRoleService;
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
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    SysRoleDao sysRoleDao;

    @Override
    public List<SysRole> findAll() {
        return sysRoleDao.findAll();
    }

    @Override
    public List<SysRole> find(SysRole condition) {
        List<SysRole> sysRoleList = null;

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
        sysRoleList = sysRoleDao.findAll(specification);

        return sysRoleList;
    }


    @Override
    public Page<List<SysRole>> findByPage(SysRole condition, Pageable pageable) {
        Page<List<SysRole>> sysRoleList = null;

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
        sysRoleList = sysRoleDao.findAll(specification, pageable);

        return sysRoleList;
    }

    @Override
    public SysRole findById(int id) {
        return sysRoleDao.getById(id);
    }

    @Override
    public boolean add(SysRole sysRole) {
        sysRoleDao.save(sysRole);
        return true;
    }

    @Override
    public boolean mod(SysRole sysRole) {
        sysRoleDao.save(sysRole);
        return true;
    }

    @Override
    public void del(int id) {
        sysRoleDao.deleteById(id);
    }
}
