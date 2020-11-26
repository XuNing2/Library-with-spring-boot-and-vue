package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.example.demo.controller.LibraryController;
import com.example.demo.dao.BookDAO;
import com.example.demo.dao.BorrowlistDAO;
import com.example.demo.dao.CategoryDAO;
import com.example.demo.dao.PermissionDAO;
import com.example.demo.dao.RoleDAO;
import com.example.demo.dao.RolePermissionDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.Borrowlist;
import com.example.demo.pojo.Category;
import com.example.demo.pojo.Permission;
import com.example.demo.pojo.Role;
import com.example.demo.pojo.RolePermission;
import com.example.demo.pojo.User;

import com.example.demo.service.BookService;
import com.example.demo.service.BorrowlistService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.PermissionService;
import com.example.demo.service.RolePermissionService;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;

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
	UserService userService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	BookService bookService;

	@Autowired
	BorrowlistDAO borrowlistDAO;

	@Autowired
	BorrowlistService borrowlistService;

	@Autowired
	LibraryController libraryController;



	@Test
	void testUser(){
		User user =new User("name", "12", "t2elephone");
		user.setRole(new Role(4, "读者"));
		user.setId(8);
		//userService.add(user);
		//userService.delById(user);
		userService.update(user);
	}

	@Test
	void testBook() {

		Category category = categoryService.getById(2);
		Book book = new Book("lzhnb", "lzh", "press", category);
		book.setId(14);
		Category category1 = categoryDAO.findById(1);
		book.setCategory(category1);
		libraryController.updateBook(book);

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
		// Category category = categoryDAO.findById(3);
		// System.out.println(category.getName());

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

		// bookDAO.deleteById(2);
		// List<Book> books = bookDAO.findAll();
		// for(Book o: books){
		// 	System.out.println(o.getTitle());
		// }

		
		System.out.print("1");
	}

	@Test
	void testBorrowlist(){
		// List<Borrowlist> borrowlists = borrowlistDAO.findByUserAndBook(1, 1);
		// for(Borrowlist borrowlist:borrowlists){
		// 	borrowlistDAO.delete(borrowlist);
		// }
		
		// Borrowlist borrowlist = new Borrowlist(1,1,false);

		// borrowlistService.add(1,1);
		List<Borrowlist> o = borrowlistDAO.findByBook(1);
        if(o.size() == 0)
			System.out.println("没有对象！");
		List<Borrowlist> borrowlists = borrowlistDAO.findByBookAndHavereturn(1, false);
		if(borrowlists == null)
			System.out.println("没有对象！");
		for(Borrowlist borrowlist:borrowlists){
			System.out.println(borrowlist.getUser());
		}
		// borrowlistService.add(1, 9);
		
		// List<Borrowlist> booklists = borrowlistDAO.findAll();
		// if(booklists.size() == 0){
		// 	System.out.println("没有对象！");
		// }
		// for(Borrowlist booklist:booklists){
		// 	Book book = bookDAO.findById(booklist.getBook());
		// 	System.out.println(book.getTitle());
		// }
		System.out.print("1");
	}

	@Autowired
	RoleDAO roleDAO;

	@Autowired
	RoleService ros;

	@Test 
	void testRole(){
		Role role = new Role(4,"jj");

		//ros.add(role);
		//System.out.print(ros.isExistByID(3));
		//assertEquals(role.getRolename(), ros.getByRoleId(5).getRolename());

		//ros.deleteByRoleId(role);

		ros.update(role);
	}


	@Autowired
	PermissionDAO perimissionDAO;

	@Autowired
	PermissionService permissionService;

	@Test
	void testPermission(){
		Permission permission = new Permission(2,"./hhhh");

		permissionService.add(permission);
		//permissionService.deleteByPermissionID(2);
		permissionService.update(permission);
	}

	@Autowired
	RolePermissionDAO rpDAO;

	@Autowired
	RolePermissionService rolepermissionService;

	@Test
	void testRolePermission(){
		RolePermission rolePermission = new RolePermission(3,1);

		// rolepermissionService.add(rolePermission);
		//rolepermissionService.deleteByRoleIDAndPermissionid(1, 2);
		rolepermissionService.update(rolePermission);


	}

}
