package com.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.model.Books;

public interface BooksRepository extends JpaRepository<Books, Long> {

	List<Books> findAll();
}
