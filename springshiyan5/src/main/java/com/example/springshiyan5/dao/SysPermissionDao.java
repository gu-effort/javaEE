package com.example.springshiyan5.dao;

import com.example.springshiyan5.entity.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SysPermissionDao extends JpaRepository<SysPermission, Integer>, JpaSpecificationExecutor<SysPermission> {
}