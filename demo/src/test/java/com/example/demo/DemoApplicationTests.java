package com.example.demo;

import java.util.List;

import com.example.demo.dao.BookDAO;
import com.example.demo.dao.BorrowlistDAO;
import com.example.demo.dao.CategoryDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.Borrowlist;
import com.example.demo.pojo.Category;
import com.example.demo.pojo.User;
import com.example.demo.service.BookService;
import com.example.demo.service.CategoryService;

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

	@Autowired
	CategoryService categoryService;

	@Autowired
	BookService bookService;

	@Autowired
	BorrowlistDAO borrowlistDAO;

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
		// Category category = categoryService.getById(3);
		// // Category category = new Category();
		// // category.setId(8);
		// category.setName("教科书");
		// categoryService.update(category);
		
		// List<Book> books = bookService.listByTitleOrAuthor("如何");
		// if(books.size() == 0){
		// 	System.out.println("没有对象！");
		// }
		// for(Book book:books){
		// 	System.out.println(book.getTitle());
		// }
		// List<Borrowlist> borrowlists = borrowlistDAO.findByUserAndBook(1, 1);
		// for(Borrowlist borrowlist:borrowlists){
		// 	borrowlistDAO.delete(borrowlist);
		// }
		
		// Borrowlist borrowlist = new Borrowlist();
		// borrowlist.setBook(1);
		// borrowlist.setUser(1);
		// borrowlist.setDate("2020.11.16");
		// borrowlist.setHavereturn(false);
		// borrowlistDAO.save(borrowlist);
		// List<Borrowlist> booklists = borrowlistDAO.findAll();
		// if(booklists.size() == 0){
		// 	System.out.println("没有对象！");
		// }
		// for(Borrowlist booklist:booklists){
		// 	Book book = bookDAO.findById(booklist.getBook());
		// 	System.out.println(book.getTitle());
		// }

		// bookDAO.deleteById(2);
		// List<Book> books = bookDAO.findAll();
		// for(Book o: books){
		// 	System.out.println(o.getTitle());
		// }

		
		System.out.print("1");
	}

}
