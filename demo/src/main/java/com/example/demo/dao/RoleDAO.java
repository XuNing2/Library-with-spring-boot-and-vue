package com.example.demo.dao;

import javax.transaction.Transactional;

import com.example.demo.pojo.Role;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleDAO extends JpaRepository<Role, Integer>{   
    //通过roleID查询
    Role findByRoleid(int roleID);
    Role findByRolename(String roleName);

    @Transactional
    void deleteByRoleid(int roleId);

}