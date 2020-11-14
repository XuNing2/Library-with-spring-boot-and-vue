package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDAO extends JpaRepository<User, Integer>{
    //通过userid查询用户
    User findById(int id);

    //通过username查询用户
    User findByUsername(String username);

    //通过用户名和密码查询用户，在登陆时需要使用
    User getByUsernameAndPassword(String username, String password);
}