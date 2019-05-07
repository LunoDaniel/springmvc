package com.mvc.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class BookFTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;
	private List<Long> authors;
	private String image;
	private Date releaseDate;
	private String resume;
	private Boolean rented = false;
	private Integer quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Long> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Long> authors) {
		this.authors = authors;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Boolean getRented() {
		return rented;
	}

	public void setRented(Boolean rented) {
		this.rented = rented;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
