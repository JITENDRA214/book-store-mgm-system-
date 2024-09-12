package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.model.Books;
import com.bookstore.model.Orders;
import com.bookstore.service.ManagerServiceInt;

@RestController
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private ManagerServiceInt managerServiceInt;

	
	
	@GetMapping("/getAllBooks")
	public List<Books> getAllBooks() {
		return managerServiceInt.getAllBooks();
	}
	
	
    @PutMapping("/books/{id}/stock")
    public Books updateBookStock(@PathVariable Long id, @RequestParam int stock) {
    	    	
    	return managerServiceInt.updateBookStock(id, stock);
    }
    
    
    @GetMapping("/getAllOreder")
    public List<Orders> getAllOrders(){
    	
    	return managerServiceInt.getAllOrders();
    }
	

}
