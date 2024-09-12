package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.Authors;
import com.bookstore.model.Books;
import com.bookstore.model.Orders;
import com.bookstore.repository.AuthorsRepository;
import com.bookstore.repository.BooksRepository;
import com.bookstore.repository.OrdersRepository;

@Service
public class AdminServiceImp implements AdminServiceInt {

	@Autowired
	private BooksRepository booksRepository;

	@Autowired
	private AuthorsRepository authorsRepository;

	@Autowired
	private OrdersRepository ordersRepository;

	public Books addBook(Books books) {

		return booksRepository.save(books);
	}

	public Books updatedBooks(Long id, Books books) {

		Optional<Books> existingBook = booksRepository.findById(id);

		if (existingBook.isPresent()) {

			Books updatedBook = existingBook.get();
			updatedBook.setIsbn(books.getIsbn());
			updatedBook.setTitle(books.getTitle());
			updatedBook.setAuthors(books.getAuthors());
			updatedBook.setPrice(books.getPrice());
			updatedBook.setStockQuantity(books.getStockQuantity());

			return booksRepository.save(updatedBook);

		} else {
			throw new RuntimeException("Book not found.");
		}

	}

	public void deleteBooks(Long id) {
		booksRepository.deleteById(id);
	}

	public Authors addAuthors(Authors authors) {
		return authorsRepository.save(authors);
	}

	public Authors updatedAuthors(Long id, Authors authors) {

		Optional<Authors> exstingAuthors = authorsRepository.findById(id);

		if (exstingAuthors.isPresent()) {

			Authors updatedAuthors = exstingAuthors.get();
			updatedAuthors.setName(authors.getName());
			updatedAuthors.setBooks(authors.getBooks());

			return authorsRepository.save(updatedAuthors);
		} else {
			throw new RuntimeException("Authors not found.");
		}
	}

	public List<Orders> getAllOrders() {

		return ordersRepository.findAll();
	}

}
