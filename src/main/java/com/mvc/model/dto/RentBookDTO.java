package com.mvc.model.dto;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

public class RentBookDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private List<BookDTO> books;
	private LocalTime rentalDate;
	private LocalTime returnDate;
	private Double value;

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

	public LocalTime getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(LocalTime rentalDate) {
		this.rentalDate = rentalDate;
	}

	public LocalTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalTime returnDate) {
		this.returnDate = returnDate;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
