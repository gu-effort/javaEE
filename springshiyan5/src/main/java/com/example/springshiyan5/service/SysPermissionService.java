package com.example.springshiyan5.service;

import com.example.springshiyan5.entity.SysPermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SysPermissionService {

    List<SysPermission> findAll();

    List<SysPermission> find(SysPermission condition);

    Page<List<SysPermission>> findByPage(SysPermission condition, Pageable pageable);

    SysPermission findById(int id);

    boolean add(SysPermission sysPermission);

    boolean mod(SysPermission sysPermission);

    void del(int id);
}
