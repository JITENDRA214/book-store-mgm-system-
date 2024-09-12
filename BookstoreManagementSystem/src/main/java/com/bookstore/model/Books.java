package com.bookstore.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String isbn;

	@Column(nullable = false)
	private String title;

	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	private Authors authors;

	@Column(nullable = false)
	private Double price;

	@Column(nullable = false)
	private Integer stockQuantity;

	@ManyToMany(mappedBy = "books")
	private List<Orders> orders;

	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Books(Long id, String isbn, String title, Authors authors, Double price, Integer stockQuantity,
			List<Orders> orders) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.authors = authors;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.orders = orders;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Authors getAuthors() {
		return authors;
	}

	public void setAuthors(Authors authors) {
		this.authors = authors;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", isbn=" + isbn + ", title=" + title + ", authors=" + authors + ", price=" + price
				+ ", stockQuantity=" + stockQuantity + ", orders=" + orders + "]";
	}
	
	


}
