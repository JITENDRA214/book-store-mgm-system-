package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.model.Books;
import com.bookstore.model.Orders;
import com.bookstore.model.Users;
import com.bookstore.repository.BooksRepository;
import com.bookstore.repository.OrdersRepository;
import com.bookstore.repository.UsersRepository;

public class CustomerServiceImp implements CustomerServiceInt {

	@Autowired
	private BooksRepository booksRepository;

	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private UsersRepository usersRepository;

	public List<Books> browsBooks() {
		return booksRepository.findAll();
	}

	public Orders placeOrder(Users users, List<Long> bookIds, int quantity) {

		List<Books> books = booksRepository.findAllById(bookIds);

		double totalPrice = books.stream().mapToDouble(Books::getPrice).sum() * quantity;

		Orders order = new Orders();

		order.setUsers(users);
		order.setBooks(books);
		order.setQuantity(quantity);
		order.setTotalPrice(totalPrice);
		// order.setOrderDate(orderDate);
		return ordersRepository.save(order);

	}

	public List<Orders> getOrderHistory(long userId) {

		Optional<Users> user = usersRepository.findById(userId);

		if (user.isPresent()) {

			return ordersRepository.findAllByUserId(userId);

		} else {
			throw new RuntimeException("User Not Found.");
		}

	}

}
