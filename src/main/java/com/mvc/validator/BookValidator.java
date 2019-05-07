package com.mvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mvc.model.dto.BookFTO;

@Component
public class BookValidator extends BaseValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return BookFTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(target instanceof BookFTO) {
			BookFTO book = (BookFTO) target;
			
			ValidationUtils.rejectIfEmpty(errors, "title", REQUIRED_FIELD);
			ValidationUtils.rejectIfEmpty(errors, "authors", REQUIRED_FIELD);
			ValidationUtils.rejectIfEmpty(errors, "image", REQUIRED_FIELD);
			ValidationUtils.rejectIfEmpty(errors, "releaseDate", REQUIRED_FIELD);
			ValidationUtils.rejectIfEmpty(errors, "resume", REQUIRED_FIELD);
			ValidationUtils.rejectIfEmpty(errors, "quantity", REQUIRED_FIELD);
		}

	}

}
