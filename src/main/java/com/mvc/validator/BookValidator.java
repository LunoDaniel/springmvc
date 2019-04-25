package com.mvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mvc.model.dto.BookDTO;

@Component
public class BookValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return BookDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

	}

}
