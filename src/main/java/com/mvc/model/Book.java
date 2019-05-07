package com.mvc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Book {

	private Long id;
	private String title;
	private List<Author> authors;
	private String image;
	private Date releaseDate;
	private String resume;
	private Boolean rented = false;
	private Integer quantity;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@ManyToMany(targetEntity = Author.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "book_author", joinColumns = 
		@JoinColumn(name = "book_id", referencedColumnName = "id"), 
		inverseJoinColumns = 
			@JoinColumn(name = "author_id", referencedColumnName = "id"))
	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	@Column(name = "image")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Basic
	@Temporal(TemporalType.DATE)
	@Column(name = "release_date")
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	@Column(name = "is_rented", columnDefinition="boolean default false")
	public Boolean getRented() {
		return rented;
	}

	public void setRented(Boolean rented) {
		this.rented = rented;
	}
	
	@Lob
	@Column(name="resume", columnDefinition="BLOB")
	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	@Column(name="quantity")
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
