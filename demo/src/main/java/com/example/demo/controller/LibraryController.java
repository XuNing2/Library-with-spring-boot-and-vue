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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import com.example.demo.utils.StringUtils;

@CrossOrigin
@RestController
public class LibraryController {
    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    CategoryService categoryService;

    //展现所有书籍

    @GetMapping("api/library/books")
    public Result getAllBook(){
        List<Book> list = bookService.getAll();
        return ResultFactory.buildSuccessResult(list);
    }

    //根据书籍类别来查询书籍
    @GetMapping(value = "api/library/categories/{cid}/books")
    public Result listBookByCategory(@PathVariable("cid") int cid){
        if(categoryService.getById(cid) != null){
            List<Book> list = bookService.listByCategory(cid);
            return ResultFactory.buildSuccessResult(list);
        }else{
            return ResultFactory.buildResult(ResultCode.FAIL, "不存在该类别！", null);
        }
    }

    @GetMapping(value = "api/library/search/1")
    public Result listByTitle(@RequestParam("keywords") String keywords){
        if("".equals(keywords)){
            return ResultFactory.buildSuccessResult(bookService.getAll());
        }else{
            return ResultFactory.buildSuccessResult(bookService.listByTitle(keywords));
        }
    }

    @GetMapping(value = "api/library/search/2")
    public Result listByPress(@RequestParam("keywords") String press){
        if("".equals(press)){
            return ResultFactory.buildSuccessResult(bookService.getAll());
        }else{
            return ResultFactory.buildSuccessResult(bookService.listByPress(press));
        }
    }

    @GetMapping(value = "api/library/search/3")
    public Result listByAuthor(@RequestParam("keywords") String keywords){
        if("".equals(keywords)){
            return ResultFactory.buildSuccessResult(bookService.getAll());
        }else{
            return ResultFactory.buildSuccessResult(bookService.listByAuthor(keywords));
        }
    }


    public Result getBookByid(@PathVariable("bid") int bid){
        if(bookService.getById(bid) != null){
            return ResultFactory.buildSuccessResult(bookService.getById(bid));
        }else{
            return ResultFactory.buildFailResult("不存在该书！");
        }
    }

    @PostMapping("api/admin/manageBook/{bid}/deleteBook")
    public Result deleteBookByid(@PathVariable("bid") int bid){
        if(bookService.getById(bid) != null){
            bookService.deleteById(bid);
            return ResultFactory.buildResult(ResultCode.SUCCESS, "删除成功", null);
        }else{
            return ResultFactory.buildFailResult("图书馆内没有该书");
        }
    }

    @PostMapping("api/admin/manageBook/addBook")
    public Result addBook(@RequestBody Book book){
        System.out.println("-----------------------------测试------------------------------------");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());
        System.out.println(book.getDate());
        System.out.println(book.getPress());
        System.out.println(book.getId());
        System.out.println(book.getCategory());
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

    @GetMapping(value = "api/firstpage/latest6books")
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

    @PostMapping("/api/covers")
    public Result coversUpload(@RequestBody MultipartFile file) throws Exception {
        String folder = "C:/libraryimg";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6)
                + file.getOriginalFilename().substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        try {
            file.transferTo(f);
            ;
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            System.out.println("调用了/api/covers接口");
            return ResultFactory.buildSuccessResult(imgURL);
        } catch (IOException e) {
            System.out.println("调用了/api/covers接口，但是报错了");
            e.printStackTrace();
            return ResultFactory.buildFailResult("");
        }
    }



    
    
}