package com.example.demo.service;

<<<<<<< HEAD
public class CategoryService {
    
=======
import com.example.demo.dao.CategoryDAO;
import com.example.demo.pojo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    public boolean isExist(String name){
        Category category = getByName(name);
        return null != category;
    }

    public Category getById(int id){
        return categoryDAO.findById(id);
    }

    public Category getByName(String name){
        return categoryDAO.findByName(name);
    }

    public void deleteById(int id){
        categoryDAO.deleteById(id);
    }

    public void add(Category category){
        if(!isExist(category.getName())){
            categoryDAO.save(category);
        }
        else{
            System.out.println("已存在该类别！");
        }
    }

    public void update(Category category){
        categoryDAO.save(category);
    }
>>>>>>> 21dc76c6b5ef736c5d81720af27d3500a3e73f24
}