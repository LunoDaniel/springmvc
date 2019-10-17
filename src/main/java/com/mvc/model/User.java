package com.mvc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import groovy.transform.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@EqualsAndHashCode
public class User extends GEntity{
	private static final long serialVersionUID = 1L;
	
	@Email
	@Column
	private String email;
	
	private String name;
	private String password;
	
	@Embedded
	private Address address;
	
	private Boolean checked;
	
	@CPF
	@NotEmpty
	@Column(name="cpf")
	private String cpf;
	
	@OneToMany(mappedBy = "user", targetEntity = RentBook.class)
	private List<RentBook> rents;
}
