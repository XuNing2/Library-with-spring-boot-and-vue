package com.example.demo.controller;

import com.example.demo.pojo.Role;
import com.example.demo.pojo.User;
import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserManagementController {
    @Autowired
    UserService userService;

    // @ResponseBody
    // @PostMapping("/personalcenter/changeInformation")
    // public Result handleRequest(){

    //     
    //     return ResultFactory.buildSuccessResult("可以修改");
    // }

    @ResponseBody
    @PostMapping("api/personalcenter/changeInformation")
    public Result changeUserInformation(@RequestBody User requestUser){
        userService.update(requestUser);
        return ResultFactory.buildSuccessResult(requestUser);

    }

    //public Result handleRequest();

    @ResponseBody
    public Result searchUserByUserID(@PathVariable("u_id") int u_id){
        return ResultFactory.buildSuccessResult(userService.getByUserid(u_id));
    }

    @ResponseBody
    public Result searchUserByUserName(@PathVariable("username") String username){
        return ResultFactory.buildSuccessResult(userService.getByUsername(username));
    }


    @ResponseBody
    public Result deleteUserByUserID(@PathVariable("u_id") int u_id){
        User user=userService.getByUserid(u_id);
        //没有通过 userID来判断是否存在的函数
        if (userService.isExist(user.getUsername()))
        {
            userService.delById(user);
            return ResultFactory.buildSuccessResult("删除成功");
        }
        else
            return ResultFactory.buildFailResult("无此用户");
    }

}
