package com.mvc.model;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class RentBook {

	private Long id;
	private List<Book> books;
	private LocalTime rentalDate;
	private LocalTime returnDate;
	private Double value;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToMany
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
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
