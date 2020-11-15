package com.example.demo;

import java.util.List;

import com.example.demo.dao.BookDAO;
import com.example.demo.dao.CategoryDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.Category;
import com.example.demo.pojo.User;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	BookDAO bookDAO;

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	UserDAO userDAO;

	@Test
	void contextLoads() {

		// Book book = new Book();
		// book.setAuthor("lzh");
		// book.setId(2);
		// book.setTitle("lzhnb");
		// book.setPress("press");

		// Category category = categoryDAO.findById(1);
		// book.setCategory(category);
		// bookDAO.save(book);

		// List<Book> book = bookDAO.findAllByPressLike("%华%");
		// if(book.size() == 0){
		// 	System.out.println("没有对象！");
		// }
		// for(Book o: book){
		// 	System.out.print(o.getTitle());
		// }

		// bookDAO.deleteById(4);
		// User user = userDAO.findById(5);
		// User user = userDAO.findByUsername("lj");
		Category category = categoryDAO.findById(3);
		System.out.println(category.getName());
		System.out.print("1");
	}

}
