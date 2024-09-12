package com.bookstore.service;

import java.util.List;

import com.bookstore.model.Authors;
import com.bookstore.model.Books;
import com.bookstore.model.Orders;

public interface AdminServiceInt {

	// books related service

	Books addBook(Books books);

	Books updatedBooks(Long id, Books books);

	void deleteBooks(Long id);

	// Authors related service

	Authors addAuthors(Authors authors);

	Authors updatedAuthors(Long id, Authors authors);

	// order related service
	List<Orders> getAllOrders();

}
