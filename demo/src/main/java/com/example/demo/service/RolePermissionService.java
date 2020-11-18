package com.example.demo.service;

import com.example.demo.dao.RolePermissionDAO;
import com.example.demo.pojo.RolePermission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionService {
    @Autowired
    RolePermissionDAO rolePermissionDAO;

    public boolean isExistByRoleIDAndPermission(int roleID,int permission){
        RolePermission rolePermission = getByRoleIDAndPermission(roleID, permission);
        return null!=rolePermission;
    }

    private RolePermission getByRoleIDAndPermission(int roleID,int permission){
        return rolePermissionDAO.findByRoleidAndPermissionid(roleID, permission);
    }

    public void add(RolePermission rolePermission){
        if(!isExistByRoleIDAndPermission(rolePermission.getRoleid(), rolePermission.getPermissionid()))
            rolePermissionDAO.save(rolePermission);
        else
            System.out.print("该角色权限已存在！");
    }

    public void deleteByRoleIDAndPermission(int roleID,int permission){
        rolePermissionDAO.deleteByRoleidAndPermissionid(roleID, permission);
    }

    public void update(RolePermission rolePermission){
        rolePermissionDAO.save(rolePermission);
    }
}
