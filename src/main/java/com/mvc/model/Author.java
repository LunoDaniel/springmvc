package com.mvc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import groovy.transform.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@EqualsAndHashCode
public class Author extends GEntity{
	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	private String name;
	
	@ManyToMany(mappedBy = "authors", targetEntity = Book.class)
	private List<Book> books;

}
