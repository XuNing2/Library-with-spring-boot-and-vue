package com.example.demo.controller;

import java.util.List;

import com.example.demo.pojo.Borrowlist;
import com.example.demo.pojo.User;
import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import com.example.demo.service.BookService;
import com.example.demo.service.BorrowlistService;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class BorrowlistController {
    @Autowired
    BorrowlistService borrowlistService;

    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    //展现借阅表所有名单
    // @GetMapping(value = )
    public Result getAll(){
        return ResultFactory.buildSuccessResult(borrowlistService.getAll());
    }

    //通过用户id查询该用户借阅记录
    @GetMapping(value = "api/personalcenter/borrowHistory/{username}")
    public Result listByUser(@PathVariable("username") String username){
        User user = userService.getByUsername(username);
        if(user != null){
            return ResultFactory.buildSuccessResult(borrowlistService.getByUser(user.getId()));
        }else{
            return ResultFactory.buildFailResult("不存在该用户！");
        }
    }


    public Result listByBook(@PathVariable("bid") int bid){
        if(bookService.getById(bid) != null){
            return ResultFactory.buildSuccessResult(borrowlistService.getByBook(bid));
        }else{
            return ResultFactory.buildFailResult("不存在该书籍！");
        }
    }

    @PostMapping(value = "api/library/borrow")
    public Result BorrowBook(@PathVariable("uid") int uid, @PathVariable("bid") int bid){
        if(userService.getByUserid(uid) == null){
            return ResultFactory.buildFailResult("不存在该用户！");
        }else if(bookService.getById(bid) == null){
            return ResultFactory.buildFailResult("不存在该书籍！");
        }else if(!borrowlistService.canBorrow(bid)){
            return ResultFactory.buildFailResult("该书已被他人借阅！");
        }else{
            borrowlistService.add(uid, bid);
            return ResultFactory.buildSuccessResult(borrowlistService.getAll());
        }        
    }

    @GetMapping(value = "api/personalcenter/returnBook")
    public Result ReturnBook(@RequestBody Borrowlist borrowlist){
        if(userService.getByUserid(borrowlist.getUser()) == null){
            return ResultFactory.buildFailResult("不存在该用户！");
        }else if(bookService.getById(borrowlist.getBook()) == null){
            return ResultFactory.buildFailResult("不存在该书籍！");
        }else{
            borrowlist.setHavereturn(true);
            borrowlistService.update(borrowlist);
            return ResultFactory.buildSuccessResult(borrowlistService.getAll());
        }
    }
}