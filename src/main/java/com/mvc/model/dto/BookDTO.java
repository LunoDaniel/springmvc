package com.mvc.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private List<AuthorDTO> authors;
	private String image;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date releaseDate;
	
	private String resume;
	private Boolean rented = false;
	private Double unitPrice;
	private Integer stockQuantity;
    
}
