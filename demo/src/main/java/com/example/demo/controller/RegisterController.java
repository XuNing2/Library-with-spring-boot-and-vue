package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import com.example.demo.result.ResultCode;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class RegisterController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @PostMapping(value="/register")
    public Result register(@RequestBody User user) {
        final  String CHINESE_LETTER_DIGIT_REGEX = "^[_a-z0-9A-Z\u4e00-\u9fa5]+$";
        if(null != user){
            System.out.println("user不为空");
            //判断命名是否含有空格等
            String name = user.getUsername();
            if(!name.matches(CHINESE_LETTER_DIGIT_REGEX)){
                System.out.println("用户昵称只能包含数字字母下划线及中文！");
                return ResultFactory.buildFailResult("用户昵称只能包含数字字母下划线及中文！");
            }
            if(userService.isExist(name))
                return ResultFactory.buildFailResult("该用户名已被注册！");
            //默认用户角色为访客
            if(user.getRole()==null){
                user.setRole(roleService.getByRoleId(4));
            }
            // Encrypt encrypt = new Encrypt();
            // String newpass = encrypt.md5Encode(user.getPassword());
            // user.setPassword(newpass);
            userService.add(user);
            return ResultFactory.buildResult(ResultCode.SUCCESS, "注册成功!", user);
        }
        else
            return ResultFactory.buildFailResult("用户信息有误");
    }
       
}