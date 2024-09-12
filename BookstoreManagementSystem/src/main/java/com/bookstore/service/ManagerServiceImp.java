package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.Books;
import com.bookstore.model.Orders;
import com.bookstore.repository.BooksRepository;
import com.bookstore.repository.OrdersRepository;

@Service
public class ManagerServiceImp implements ManagerServiceInt {

	@Autowired
	private BooksRepository booksRepository;

	@Autowired
	private OrdersRepository ordersRepository;

	public List<Books> getAllBooks() {
		return booksRepository.findAll();
	}

	public Books updateBookStock(Long id, int newStock) {

		Optional<Books> existingBook = booksRepository.findById(id);

		if (existingBook.isPresent()) {

			Books book = existingBook.get();
			book.setStockQuantity(newStock);

			return booksRepository.save(book);

		} else {

			throw new RuntimeException("Book not found");
		}

	}
	
	

	public List<Orders> getAllOrders() {

		return ordersRepository.findAll();
	}

}
