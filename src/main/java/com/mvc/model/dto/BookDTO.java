package com.mvc.model.dto;

import java.time.LocalTime;
import java.util.List;

public class BookDTO {

	private Long id;
	private String title;
	private List<AuthorDTO> authors;
	private String image;
	private LocalTime date;
	private String resume;
	private Boolean rented;
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

	public List<AuthorDTO> getAuthors() {
		return authors;
	}

	public void setAuthors(List<AuthorDTO> authors) {
		this.authors = authors;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocalTime getDate() {
		return date;
	}

	public void setDate(LocalTime date) {
		this.date = date;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
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
