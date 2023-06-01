package com.example.springshiyan5.service;

import com.example.springshiyan5.entity.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SysUserService {

    List<SysUser> findAll();

    List<SysUser> find(SysUser condition);

    Page<List<SysUser>> findByPage(SysUser condition, Pageable pageable);

    SysUser findById(int id);

    SysUser findByUsername(String username);

    boolean add(SysUser sysUser);

    boolean mod(SysUser sysUser);

    void del(int id);

    boolean resetPwd(int id);

//    boolean resetPwd(int id);
}
