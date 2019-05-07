package com.mvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mvc.model.dto.BookFTO;

@Component
public class BookValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return BookFTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

	}

}
