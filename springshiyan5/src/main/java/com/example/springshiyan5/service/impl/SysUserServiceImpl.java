package com.example.springshiyan5.service.impl;


import com.example.springshiyan5.dao.SysUserDao;
import com.example.springshiyan5.entity.SysUser;
import com.example.springshiyan5.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {


    @Autowired
    SysUserDao
            sysUserDao;

    @Override
    public List<SysUser> findAll() {
        return sysUserDao.findAll();
    }

    @Override
    public List<SysUser> find(SysUser condition) {
        List<SysUser> sysUserList = null;

        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (condition.getId() != null) {
                    Predicate predicate = criteriaBuilder.equal(root.get("id").as(Integer.class), condition.getId());
                    predicates.add(predicate);
                }
                if (StringUtils.hasLength(condition.getUsername())) {
                    Predicate predicate = criteriaBuilder.like(root.get("username").as(String.class), "%" + condition.getUsername() + "%");
                    predicates.add(predicate);
                }
//                if (condition.getRoles() != null && condition.getRo().getId() != null) {
//                    Predicate predicate = criteriaBuilder.equal(root.get("dep").get("id").as(Integer.class), condition.getDep().getId());
//                    predicates.add(predicate);
//                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        sysUserList = sysUserDao.findAll(specification);

        return sysUserList;
    }


    @Override
    public Page<List<SysUser>> findByPage(SysUser condition, Pageable pageable) {
        Page<List<SysUser>> sysUserList = null;

        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.hasLength(condition.getUsername())) {
                    Predicate predicate = criteriaBuilder.like(root.get("username").as(String.class), "%" + condition.getUsername() + "%");
                    predicates.add(predicate);
                }
//                if (condition.getRole() != null && condition.getRole().getId() != null) {
//
//                    Predicate predicate = criteriaBuilder.equal(root.get("role").get("id").as(Integer.class), condition.getRole().getId());
//                    predicates.add(predicate);
//                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        sysUserList = sysUserDao.findAll(specification, pageable);

        return sysUserList;
    }

    @Override
    public SysUser findById(int id) {
        return sysUserDao.getById(id);
    }

    @Override
    public SysUser findByUsername(String username) {
        System.out.println(":::::::::::" + this.getClass() + ": " + username);
        return sysUserDao.findByUsername(username);
    }

    @Override
    public boolean add(SysUser sysUser) {
        sysUser.setPassword(new BCryptPasswordEncoder().encode(sysUser.getPassword()));
        sysUserDao.save(sysUser);
        return true;
    }

    @Override
    public boolean mod(SysUser sysUser) {
        sysUserDao.save(sysUser);
        return true;
    }

    @Override
    public void del(int id) {
        sysUserDao.deleteById(id);
    }

    @Override
    public boolean resetPwd(int id) {
        String newPwd = new BCryptPasswordEncoder().encode("123");
        sysUserDao.resetPwd(id, newPwd);
        return true;
    }
}
