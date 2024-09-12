package com.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

  List<Orders>  findAll();
  
  List<Orders> findAllByUserId(Long userId);
}
