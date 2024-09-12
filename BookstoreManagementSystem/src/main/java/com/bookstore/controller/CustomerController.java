package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.model.Books;
import com.bookstore.model.Orders;
import com.bookstore.model.Users;
import com.bookstore.service.CustomerServiceInt;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	private CustomerServiceInt  customerServiceInt;
	
	
	@GetMapping("/books")
	public List<Books> browsBooks(){
		
		return customerServiceInt.browsBooks();
	}
	
	
	
	@PostMapping("/plaseOrder")
	public Orders pleaseOrder(@RequestParam Long userId, @RequestParam List<Long> bookIds, @RequestParam int quantity ) {
		
		Users user=new Users();
		
		return customerServiceInt.placeOrder(user, bookIds, quantity);
	}
	
	
	@GetMapping("/orderHistory/{userId}")
	public List<Orders>  getOrdersHistory(@PathVariable Long userId){
		
		return  customerServiceInt.getOrderHistory(userId);
		
	}
	
	
	

}
