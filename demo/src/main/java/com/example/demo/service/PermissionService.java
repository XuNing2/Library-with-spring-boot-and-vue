package com.example.demo.service;

import com.example.demo.dao.PermissionDAO;
import com.example.demo.pojo.Permission;

import org.springframework.beans.factory.annotation.Autowired;

public class PermissionService {
    @Autowired
    PermissionDAO permissionDAO;

    public boolean isExist(int permissionID) {
        Permission permission = getByPermissionId(permissionID);
        return null!=permission;
    }

    private Permission getByPermissionId(int permissionID) {
        return permissionDAO.findByPermissionID(permissionID);
    }
    

    public void add(Permission permission) {
        if(!isExist(permission.getPermissionID()))
            permissionDAO.save(permission);
        else
            System.out.print("该权限已存在！");
    }

    public void deleteByPermissionID(Permission permission) {
            permissionDAO.deleteByPermissionID(permission.getPermissionID());

    }

    public void update(Permission permission) {
        permissionDAO.save(permission);
    }
}
