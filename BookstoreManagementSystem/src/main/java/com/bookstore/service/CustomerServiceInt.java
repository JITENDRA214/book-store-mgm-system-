package com.bookstore.service;

import java.util.List;

import com.bookstore.model.Books;
import com.bookstore.model.Orders;
import com.bookstore.model.Users;

public interface CustomerServiceInt {

	
	List<Books>  browsBooks();
	
	Orders placeOrder(Users users, List<Long> bookIds, int quantity);
	
	List<Orders> getOrderHistory(long userId);
	
		
}