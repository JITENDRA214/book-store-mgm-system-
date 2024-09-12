package com.bookstore.service;

import java.util.List;

import com.bookstore.model.Books;
import com.bookstore.model.Orders;

public interface ManagerServiceInt {
	
	// books related service
	List<Books> getAllBooks();
	
	// update stock for book 
    Books updateBookStock(Long id, int newstock);
	
	// order related service 
	List<Orders> getAllOrders();
}
