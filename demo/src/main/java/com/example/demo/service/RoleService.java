package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.RoleDAO;
import com.example.demo.pojo.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleDAO roleDAO;

    public List<Role> getAll(){
        return roleDAO.findAll();
    }

    public boolean isExistByName(String roleName){
        Role role  = getByRoleName(roleName);
        return null!=role;
    }

    public Role getByRoleName(String roleName) {
        return roleDAO.findByRolename(roleName);
    }

    public boolean isExistByID(int roleId){
        Role role  = getByRoleId(roleId);
        return null!=role;
    }

    public Role getByRoleId(int roleId) {
        return roleDAO.findByRoleid(roleId);
    }

    public void add(Role role) {
        if(!isExistByID(role.getRoleid()))
            roleDAO.save(role);
        else
            System.out.print("该角色已存在！");
    }

    public void update(Role role) {
        roleDAO.save(role);
    }

    public void deleteByRoleId(Role role) {
        roleDAO.deleteByRoleid(role.getRoleid());
    }
}
