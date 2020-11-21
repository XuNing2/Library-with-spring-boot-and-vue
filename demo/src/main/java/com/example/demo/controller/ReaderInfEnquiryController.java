package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReaderInfEnquiryController {
    @Autowired
    UserService userService;

    // @CrossOrigin
    // @GetMapping("/personalcenter_state=pi")
    // @ResponseBody
    // public Result viewUserInformationByUserID(@PathVariable("u_id") int u_id){
        
    //     return ResultFactory.buildSuccessResult(userService.getByUserid(u_id));
    // }  
    
    @CrossOrigin
    @GetMapping("api/personalcenter/{username}/personalInformation")
    @ResponseBody
    public Result viewUserInformationByUserName(@PathVariable("username") String username){
        
        return ResultFactory.buildSuccessResult(userService.getByUsername(username));
    }  





}