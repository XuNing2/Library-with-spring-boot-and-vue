package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.UserDAO;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public List<User> getAll() {
        return userDAO.findAll();
    }
    
    
    public boolean isExist(String username) {
        User user = getByUsername(username);
        return null!=user;
    }

    public User getByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    public User getByUserid(int userid){
        return userDAO.findById(userid);
    }

    public User get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        if(!isExist(user.getUsername()))
            userDAO.save(user);
        else
            System.out.print("该用户已存在！");
    }

    public void update(User user) {
        userDAO.save(user);
    }

    public void delById(int u_id){
        userDAO.deleteById(u_id);
    }

    
}