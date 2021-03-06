package com.example.demo.dao;

import javax.transaction.Transactional;

import com.example.demo.pojo.RolePermission;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RolePermissionDAO extends JpaRepository<RolePermission, Integer>{  

    RolePermission findByRoleidAndPermissionid(int roleID,int permission);
    
    @Transactional
    void deleteByRoleidAndPermissionid(int roleID,int permission);
}