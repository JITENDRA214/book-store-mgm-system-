package com.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.model.Authors;

public interface AuthorsRepository extends JpaRepository<Authors, Long> {
	
	List<Authors> findAll();

}
