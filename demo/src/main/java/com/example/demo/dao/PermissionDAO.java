package com.example.demo.dao;

import javax.transaction.Transactional;

import com.example.demo.pojo.Permission;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PermissionDAO extends JpaRepository<Permission, Integer>{   
    //通过PermissionID查询
    Permission findByPermissionid(int PermissionID);

    @Transactional
	void deleteByPermissionid(int permissionID);

}