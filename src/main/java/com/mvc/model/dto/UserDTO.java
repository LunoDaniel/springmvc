package com.mvc.model.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	private String name;
	private String password;
	private AddressDTO address;
	private Boolean checked;
	private String cpf;
}
