package com.mvc.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RentBookDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private List<BookDTO> books = new ArrayList<>();
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date rentalDate;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date returnDate;
	
	private Double totalRentValue;
	private UserDTO user;

	@JsonIgnore
	private void totalRentValue() {
		Integer quantity = books.size();
		books.forEach(item -> totalRentValue += (quantity * item.getUnitPrice()));
	}

}
