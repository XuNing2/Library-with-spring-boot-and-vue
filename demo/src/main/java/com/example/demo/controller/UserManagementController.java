package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
public class UserManagementController {
    @Autowired
    UserService userService;

    // @ResponseBody
    // @PostMapping("/personalcenter/changeInformation")
    // public Result handleRequest(){

    //     
    //     return ResultFactory.buildSuccessResult("可以修改");
    // }
    @GetMapping("api/admin/manageUser")
    public Result getAllUser(){
        List<User> list = userService.getAll();
        return ResultFactory.buildSuccessResult(list);
    }
    
    @PostMapping("api/personalcenter/changeInformation")
    public Result changeUserInformation(@RequestBody User requestUser){
        userService.update(requestUser);
        return ResultFactory.buildSuccessResult(requestUser);

    }

    //public Result handleRequest();

   
    public Result searchUserByUserID(@PathVariable("u_id") int u_id){
        return ResultFactory.buildSuccessResult(userService.getByUserid(u_id));
    }

    
    public Result searchUserByUserName(@PathVariable("username") String username){
        return ResultFactory.buildSuccessResult(userService.getByUsername(username));
    }


    
    @PostMapping("api/admin/manageUser/{username}/deleteUser")
    public Result deleteUserByUserID(@PathVariable("username") String username){
       
        //没有通过 userID来判断是否存在的函数
        if (userService.isExist(username))
        {
            User user=userService.getByUsername(username);
            userService.delById(user.getId());
            return ResultFactory.buildSuccessResult("删除成功");
        }
        else
            return ResultFactory.buildFailResult("无此用户");
    }

    
    @PostMapping("api/admin/manageUser/addUser")
    public Result addUserByUserID(@RequestBody User requestUser){
       
        if (userService.isExist(requestUser.getUsername()))
        {
           return ResultFactory.buildFailResult("此用户已存在");
        }
        else
        {
            userService.add(requestUser);
            if(userService.isExist(requestUser.getUsername()))
                return ResultFactory.buildSuccessResult("已添加此用户");
            else
                return ResultFactory.buildFailResult("添加不成功，请重试");
            
        }
    }

}
