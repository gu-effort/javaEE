package com.example.springshiyan5.service;

import com.example.springshiyan5.entity.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SysRoleService {

    List<SysRole> findAll();

    List<SysRole> find(SysRole condition);

    Page<List<SysRole>> findByPage(SysRole condition, Pageable pageable);

    SysRole findById(int id);

    boolean add(SysRole sysRole);

    boolean mod(SysRole sysRole);

    void del(int id);
}
