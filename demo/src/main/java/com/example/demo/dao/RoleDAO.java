package com.example.demo.dao;

import com.example.demo.pojo.Category;
import com.example.demo.pojo.Role;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleDAO extends JpaRepository<Category, Integer>{   
    //通过roleID查询
    Role findByRoleID(int roleID);
    Role findByRoleName(String roleName);

    void deleteByRoleId(int roleId);
	void save(Role role);
}