package com.example.demo.dao;

import com.example.demo.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryDAO extends JpaRepository<Category, Integer>{   
    //通过categoryid查询，即查询类别名字
    Category findById(int id);
<<<<<<< HEAD
=======

    Category findByName(String name);
>>>>>>> 21dc76c6b5ef736c5d81720af27d3500a3e73f24
}