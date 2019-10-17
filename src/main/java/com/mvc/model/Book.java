package com.mvc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import groovy.transform.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@EqualsAndHashCode
public class Book extends GEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "title")
	private String title;
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@ManyToMany(targetEntity = Author.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "book_author", joinColumns = 
		@JoinColumn(name = "book_id", referencedColumnName = "id"), 
		inverseJoinColumns = 
			@JoinColumn(name = "author_id", referencedColumnName = "id"))
	private List<Author> authors;
	
	@Column(name = "image")
	private String image;
	
	@Basic
	@Temporal(TemporalType.DATE)
	@Column(name = "release_date")
	private Date releaseDate;
	
	@Lob
	@Column(name="resume", columnDefinition="BLOB")
	private String resume;
	
	@Column(name = "rented", columnDefinition="boolean default false")
	private Boolean rented = false;
	
	@Column(name = "unit_price")
	private Double unitPrice;
	
	@Column(name = "stock_quantity")
	private Integer stockQuantity;
}
