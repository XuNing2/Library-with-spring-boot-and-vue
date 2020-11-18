package com.example.demo.dao;


import com.example.demo.pojo.RolePermission;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RolePermissionDAO extends JpaRepository<RolePermission, Integer>{  

    RolePermission findByRoleIDAndPermissionID(int roleID,int permission);
    void deleteByRoleIDAndPermissionID(int roleID,int permission);
}
