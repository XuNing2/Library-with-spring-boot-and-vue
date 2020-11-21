package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import com.example.demo.result.ResultCode;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    UserService userService;


    @PostMapping(value = "api/login")
    public Result login(@RequestBody User requestUser, HttpSession session) {
        // Encrypt encrypt = new Encrypt();
        // String newpass = encrypt.md5Encode(requestUser.getPassword());
        // requestUser.setPassword(newpass);

        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        // String indirectPassword = loginEncrypt.md5Encode(requestUser.getPassword());
        System.out.println(requestUser.getPassword());
        User user = userService.get(username, requestUser.getPassword());
        System.out.println("get方法执行了");
        if (null == user) {
            System.out.println("错误");
            return ResultFactory.buildFailResult("用户名或密码错误！");
        } else {
            session.setAttribute("user", user);
            return ResultFactory.buildResult(ResultCode.SUCCESS, "登陆成功！", user);
        }
    }
}