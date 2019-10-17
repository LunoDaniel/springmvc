package com.mvc.model.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddressDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String street;
	private String state;
	private String city;
	private String zipCode;
}
