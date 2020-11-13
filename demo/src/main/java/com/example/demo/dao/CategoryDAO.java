package com.example.demo.dao;

import com.example.demo.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryDAO extends JpaRepository<Category, Integer>{
    Category findById(int id);

    Category findByUsername(String username);

    Category getByUsernameAndPassword(String username, String password);
}