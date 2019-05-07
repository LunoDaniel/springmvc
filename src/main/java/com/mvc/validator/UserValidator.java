package com.mvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mvc.model.dto.UserDTO;

@Component
public class UserValidator implements Validator {

	private UserDTO user = new UserDTO();
	private static final String REQUIRED_FIELD= "err.required";
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(target instanceof UserDTO) {
			user = (UserDTO) target;
			
			ValidationUtils.rejectIfEmpty(errors, "password", REQUIRED_FIELD);
			ValidationUtils.rejectIfEmpty(errors, "email", REQUIRED_FIELD);
			ValidationUtils.rejectIfEmpty(errors, "name", REQUIRED_FIELD);
			ValidationUtils.rejectIfEmpty(errors, "address.street", REQUIRED_FIELD);
			ValidationUtils.rejectIfEmpty(errors, "address.state", REQUIRED_FIELD);
			ValidationUtils.rejectIfEmpty(errors, "address.city", REQUIRED_FIELD);
			ValidationUtils.rejectIfEmpty(errors, "address.zipCode", REQUIRED_FIELD);
			ValidationUtils.rejectIfEmpty(errors, "cpf", REQUIRED_FIELD);
			
		}
		
		if(errors.hasErrors()) {
			errors.reject("err.required.fields");
		}
	}
}
