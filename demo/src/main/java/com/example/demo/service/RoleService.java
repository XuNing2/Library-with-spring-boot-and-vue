package com.example.demo.service;

import com.example.demo.dao.RoleDAO;
import com.example.demo.pojo.Role;

import org.springframework.beans.factory.annotation.Autowired;

public class RoleService {
    @Autowired
    RoleDAO roleDAO;

    public boolean isExistByName(String roleName){
        Role role  = getByRoleName(roleName);
        return null!=role;
    }

    private Role getByRoleName(String roleName) {
        return roleDAO.findByRoleName(roleName);
    }

    public boolean isExistByID(int roleId){
        Role role  = getByRoleId(roleId);
        return null!=role;
    }

    private Role getByRoleId(int roleId) {
        return roleDAO.findByRoleID(roleId);
    }

    public void add(Role role) {
        if(!isExistByID(role.getRoleID()))
            roleDAO.save(role);
        else
            System.out.print("该角色已存在！");
    }

    public void deleteByRoleId(Role role) {
        roleDAO.deleteByRoleId(role.getRoleID());
    }
}
