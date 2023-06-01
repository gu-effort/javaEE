package com.example.springshiyan5.dao;

import com.example.springshiyan5.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface SysUserDao extends JpaRepository<SysUser, Integer>, JpaSpecificationExecutor<SysUser> {

    @Modifying
    @Query("update SysUser u set u.password=:newPassword where u.id=:id")
    void resetPwd(Integer id,String newPassword);


    SysUser findByUsername(String username);




}
