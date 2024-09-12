package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.model.Authors;
import com.bookstore.model.Books;
import com.bookstore.model.Orders;
import com.bookstore.service.AdminServiceInt;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminServiceInt  adminServiceInt;

	
	@PostMapping("/addNewBooks")
	public Books addBook(@RequestBody Books books) {		
		return adminServiceInt.addBook(books);	
	}	
	
	
	@PutMapping("/updateBooks/{id}")
	public Books updateBook(@PathVariable long id, @RequestBody Books books) {
		return adminServiceInt.updatedBooks(id, books);
	}
	
	
	@DeleteMapping("/deleteBook/{id}")
	public void deleteBook(@PathVariable long id) {
		 adminServiceInt.deleteBooks(id);
	}
	
	
	@PostMapping("/addNewAuthors")
	public Authors addAuthors(@RequestBody Authors authors) {
		
		return adminServiceInt.addAuthors(authors);
	}
	
	
	@PutMapping("/updateAuthors/{id}")
	public Authors updateAuthors(@PathVariable long id, @RequestBody Authors authors) {
		
		return adminServiceInt.updatedAuthors(id, authors);
	}
	
	
	@GetMapping("/orders")
	public List<Orders> viewAllOrders(){
		return adminServiceInt.getAllOrders();
	}
	
	
}

