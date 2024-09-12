package com.bookstore.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Users users;

	@ManyToMany
	@JoinTable(name = "order_books", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
	private List<Books> books;

	@Column(nullable = false)
	private Integer quantity;

	@Column(nullable = false)
	private Double totalPrice;

	@Column(nullable = false)
	private LocalDate orderDate;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(Long id, Users users, List<Books> books, Integer quantity, Double totalPrice, LocalDate orderDate) {
		super();
		this.id = id;
		this.users = users;
		this.books = books;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", users=" + users + ", books=" + books + ", quantity=" + quantity + ", totalPrice="
				+ totalPrice + ", orderDate=" + orderDate + "]";
	}

}
