package com.example.demo.dao;

import com.example.demo.pojo.Category;
import com.example.demo.pojo.Permission;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PermissionDAO extends JpaRepository<Category, Integer>{   
    //通过PermissionID查询
    Permission findByPermissionID(int PermissionID);

	void save(Permission permission);

	void deleteByPermissionID(int permissionID);

}