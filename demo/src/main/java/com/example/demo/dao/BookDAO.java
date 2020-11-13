package com.example.demo.dao;

import com.example.demo.pojo.Book;
import com.example.demo.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDAO extends JpaRepository<Book, Integer>{
    Book findById(int id);

    List<Book> findAllByCategory(Category category);

    List<Book> findAllByPressLike(String press);

    List<Book> findAllByTitleLikeOrAuthorLike(String title, String author);

    void deleteById(int id);
}