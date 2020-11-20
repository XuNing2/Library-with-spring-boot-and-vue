package com.example.demo.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.example.demo.dao.BookDAO;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    public List<Book> getAll(){
        return bookDAO.findAll();
    }

    public List<Book> listByCategory(int cid){
        Category category = categoryService.getById(cid);
        return bookDAO.findAllByCategory(category);
    }

    public List<Book> listByPress(String press){
        return bookDAO.findAllByPressLike("%" + press + "%");
    }

    public List<Book> listByTitle(String title){
        return bookDAO.findAllByTitleLike("%" + title + "%");
    }

    public List<Book> listByAuthor(String author){
        return bookDAO.findAllByAuthorLike("%" + author + "%");
    }

    public Book getById(int id){
        return bookDAO.findById(id);
    }

    public void deleteById(int id){
        bookDAO.deleteById(id);
    }

    public void addOrupdate(Book book){
        bookDAO.save(book);
    }

    public List<Book> sortDate(List<Book> list){

        Collections.sort(list, new Comparator<Book>(){
            public int compare(Book o1, Book o2) {
                //按照日期进行降序排列
                if(o1.getDate().compareTo(o2.getDate())==0){
                    return 1;
                }else{
                    return o2.getDate().compareTo(o1.getDate());
                }    }
        });
        
        return list;
    }

}