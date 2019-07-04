package com.mvc.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class RentBookDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private List<BookDTO> books = new ArrayList<>();
	private Date rentalDate;
	private Date returnDate;
	private Double totalRentValue;
	private UserDTO user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<BookDTO> getBooks() {
		return books;
	}

	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public Double getTotalRentValue() {
		totalRentValue();
		return totalRentValue;
	}

	public void setTotalRentValue(Double totalRentValue) {
		this.totalRentValue = totalRentValue;
	}

	private void totalRentValue() {
		Integer quantity = books.size();
		books.forEach(item -> totalRentValue += (quantity * item.getUnitPrice()));
	}

}
