package com.example.demo.dao;

import com.example.demo.pojo.Book;
import com.example.demo.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BookDAO extends JpaRepository<Book, Integer>,JpaSpecificationExecutor<Book>{
    //通过bookid查询书
    Book findById(int id);

    //通过类别查询
    List<Book> findAllByCategory(Category category);

    //通过出版社查询
    List<Book> findAllByPressLike(String press);

    //通过书名或者作者名查询、模糊查询
    List<Book> findAllByTitleLikeOrAuthorLike(String title, String author);

    //通过bookid删除书
    void deleteById(int id);
}