package com.mvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mvc.model.dto.UserDTO;

@Component
public class UserValidator implements Validator {

	private UserDTO user = new UserDTO();
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(target instanceof UserDTO) {
			user = (UserDTO) target;
			
			ValidationUtils.rejectIfEmpty(errors, "password", "err.required");
			ValidationUtils.rejectIfEmpty(errors, "email", "err.required");
			ValidationUtils.rejectIfEmpty(errors, "name", "err.required");
			ValidationUtils.rejectIfEmpty(errors, "address.street", "err.required");
			ValidationUtils.rejectIfEmpty(errors, "address.state", "err.required");
			ValidationUtils.rejectIfEmpty(errors, "address.city", "err.required");
			ValidationUtils.rejectIfEmpty(errors, "address.zipCode", "err.required");
			
		}
		
		if(errors.hasErrors()) {
			errors.reject("err.required.fields");
		}
	}

}
