package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.demo.pojo.Book;
import com.example.demo.result.Result;
import com.example.demo.result.ResultCode;
import com.example.demo.result.ResultFactory;
import com.example.demo.service.BookService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LibraryController {
    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    CategoryService categoryService;

    //展现所有书籍
    @GetMapping(value = "library/books")
    @ResponseBody
    public Result getAllBook(){
        List<Book> list = bookService.getAll();
        return ResultFactory.buildSuccessResult(list);
    }

    //根据书籍类别来查询书籍
    @GetMapping(value = "library/categories/{cid}/books")
    @ResponseBody
    public Result listBookByCategory(@PathVariable("cid") int cid){
        if(categoryService.getById(cid) != null){
            List<Book> list = bookService.listByCategory(cid);
            return ResultFactory.buildSuccessResult(list);
        }else{
            return ResultFactory.buildResult(ResultCode.FAIL, "不存在该类别！", null);
        }
    }

    @GetMapping(value = "library/search/1")
    @ResponseBody
    public Result listByTitle(@RequestParam("keywords") String keywords){
        if("".equals(keywords)){
            return ResultFactory.buildSuccessResult(bookService.getAll());
        }else{
            return ResultFactory.buildSuccessResult(bookService.listByTitle(keywords));
        }
    }

    @GetMapping(value = "library/search/2")
    @ResponseBody
    public Result listByPress(@RequestParam("press") String press){
        if("".equals(press)){
            return ResultFactory.buildSuccessResult(bookService.getAll());
        }else{
            return ResultFactory.buildSuccessResult(bookService.listByPress(press));
        }
    }

    @GetMapping(value = "library/search/3")
    @ResponseBody
    public Result listByAuthor(@RequestParam("keywords") String keywords){
        if("".equals(keywords)){
            return ResultFactory.buildSuccessResult(bookService.getAll());
        }else{
            return ResultFactory.buildSuccessResult(bookService.listByAuthor(keywords));
        }
    }


    @ResponseBody
    public Result getBookByid(@PathVariable("bid") int bid){
        if(bookService.getById(bid) != null){
            return ResultFactory.buildSuccessResult(bookService.getById(bid));
        }else{
            return ResultFactory.buildFailResult("不存在该书！");
        }
    }

    @ResponseBody
    public Result deleteBookByid(@PathVariable("bid") int bid){
        if(bookService.getById(bid) != null){
            bookService.deleteById(bid);
            return ResultFactory.buildResult(ResultCode.SUCCESS, "删除成功", null);
        }else{
            return ResultFactory.buildFailResult("图书馆内没有该书");
        }
    }

    @ResponseBody
    public Result addBook(@RequestBody Book book){
        System.out.println("-----------------------------测试------------------------------------");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        book.setDate(df.format(new Date()));
        if(book.getTitle() == null || "".equals(book.getTitle().trim())){
            return ResultFactory.buildFailResult("书名不能为空！");
        }

        if(book.getAuthor() == null || "".equals(book.getAuthor().trim())){
            return ResultFactory.buildFailResult("作者不能为空！");
        }

        if(book.getPress() == null || "".equals(book.getPress().trim())){
            return ResultFactory.buildFailResult("出版社不能为空！");
        }
        bookService.addOrupdate(book);
        book.print();
        return ResultFactory.buildSuccessResult(book);
    }

    @ResponseBody
    public Result updateBook(@RequestBody Book book){
        // System.out.println("-----------------------------测试------------------------------------");
        // SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // book.setDate(df.format(new Date()));
        if(book.getTitle() == null || "".equals(book.getTitle().trim())){
            return ResultFactory.buildFailResult("书名不能为空！");
        }

        if(book.getAuthor() == null || "".equals(book.getAuthor().trim())){
            return ResultFactory.buildFailResult("作者不能为空！");
        }

        if(book.getPress() == null || "".equals(book.getPress().trim())){
            return ResultFactory.buildFailResult("出版社不能为空！");
        }
        Book book1 = bookService.getById(book.getId());
        book1.setAuthor(book.getAuthor());
        book1.setCategory(book.getCategory());
        book1.setTitle(book.getTitle());
        book1.setPress(book.getPress());
        bookService.addOrupdate(book1);
        book1.print();
        return ResultFactory.buildSuccessResult(book);
    }

    @GetMapping(value = "/books/latest6books")
    @ResponseBody
    public Result getLatestItems()throws Exception{
        List<Book> list = bookService.getAll();
        list = bookService.sortDate(list);
        if(list.size()<10){
            return ResultFactory.buildSuccessResult(list);
        }
        else{
            return ResultFactory.buildSuccessResult(list.subList(0, 10));
        }

    }



    
    
}