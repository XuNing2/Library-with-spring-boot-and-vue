package com.example.demo.dao;

import com.example.demo.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryDAO extends JpaRepository<Category, Integer>{   
    //通过categoryid查询，即查询类别名字
    Category findById(int id);

    Category findByName(String name);
}