package com.example.demo.service;

import com.example.demo.dao.PermissionDAO;
import com.example.demo.pojo.Permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PermissionService {
    @Autowired
    PermissionDAO permissionDAO;

    public boolean isExist(int permissionID) {
        Permission permission = getByPermissionID(permissionID);
        return null!=permission;
    }

    private Permission getByPermissionID(int permissionID) {
        return permissionDAO.findByPermissionid(permissionID);
    }
    

    public void add(Permission permission) {
        if(!isExist(permission.getPermissionid()))
            permissionDAO.save(permission);
        else
            System.out.print("该权限已存在！");
    }

    public void deleteByPermissionID(int i) {
            permissionDAO.deleteByPermissionid(i);

    }

    public void update(Permission permission) {
        permissionDAO.save(permission);
    }
}
