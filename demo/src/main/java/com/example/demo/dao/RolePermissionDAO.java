package com.example.demo.dao;

import com.example.demo.pojo.Category;
import com.example.demo.pojo.Permission;
import com.example.demo.pojo.RolePermission;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RolePermissionDAO extends JpaRepository<Category, Integer>{  

    RolePermission findByRoleIDAndPermission(int roleID,Permission permission);
    void deleteByRoleIDAndPermission(int roleID,Permission permission);
    void save(RolePermission rolePermission);
}
