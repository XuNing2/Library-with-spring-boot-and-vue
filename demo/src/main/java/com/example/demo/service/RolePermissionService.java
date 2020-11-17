package com.example.demo.service;

import com.example.demo.dao.RolePermissionDAO;
import com.example.demo.pojo.Permission;
import com.example.demo.pojo.RolePermission;

import org.springframework.beans.factory.annotation.Autowired;

public class RolePermissionService {
    @Autowired
    RolePermissionDAO rolePermissionDAO;

    public boolean isExistByRoleIDAndPermission(int roleID,Permission permission){
        RolePermission rolePermission = getByRoleIDAndPermission(roleID, permission);
        return null!=rolePermission;
    }

    private RolePermission getByRoleIDAndPermission(int roleID,Permission permission){
        return rolePermissionDAO.findByRoleIDAndPermission(roleID, permission);
    }

    public void add(RolePermission rolePermission){
        if(!isExistByRoleIDAndPermission(rolePermission.getRoleID(), rolePermission.getPermission()))
            rolePermissionDAO.save(rolePermission);
        else
            System.out.print("该角色权限已存在！");
    }

    public void deleteByRoleIDAndPermission(int roleID,Permission permission){
        rolePermissionDAO.deleteByRoleIDAndPermission(roleID, permission);
    }

    public void update(RolePermission rolePermission){
        rolePermissionDAO.save(rolePermission);
    }
}
