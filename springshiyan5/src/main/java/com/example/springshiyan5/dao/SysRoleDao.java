package com.example.springshiyan5.dao;

import com.example.springshiyan5.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleDao extends JpaRepository<SysRole, Integer>, JpaSpecificationExecutor<SysRole> {
}
