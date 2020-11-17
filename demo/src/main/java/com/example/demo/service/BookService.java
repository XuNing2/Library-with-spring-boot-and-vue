package com.example.demo.service;

<<<<<<< HEAD
public class BookService {
    
=======
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

    public List<Book> listByCategory(String name){
        Category category = categoryService.getByName(name);
        return bookDAO.findAllByCategory(category);
    }

    public List<Book> listByPress(String press){
        return bookDAO.findAllByPressLike("%" + press + "%");
    }

    public List<Book> listByTitleOrAuthor(String keywords){
        return bookDAO.findAllByTitleLikeOrAuthorLike("%" + keywords + "%", "%" + keywords + "%");
    }

    public Book getById(int id){
        return bookDAO.findById(id);
    }

    public void addOrupdate(Book book){
        bookDAO.save(book);
    }

>>>>>>> 21dc76c6b5ef736c5d81720af27d3500a3e73f24
}