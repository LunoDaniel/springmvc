package com.mvc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import groovy.transform.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@EqualsAndHashCode
public class RentBook extends GEntity {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@ManyToMany
	private List<Book> books;
	
	
	private Date rentalDate;
	private Date returnDate;
	private Double totalRentValue;
	
	@ManyToOne(targetEntity = User.class)
	private User user;

}
