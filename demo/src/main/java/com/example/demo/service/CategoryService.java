package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.CategoryDAO;
import com.example.demo.pojo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    public List<Category> getAll(){
        return categoryDAO.findAll();
    }

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
}