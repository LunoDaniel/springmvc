package com.mvc.converter;

import org.springframework.stereotype.Component;

import com.mvc.model.User;
import com.mvc.model.dto.UserDTO;

@Component
public class UserConverter extends BaseConverter<UserDTO, User>{

	public UserDTO convertToDTO(User source) {
		return super.convertToDTO(source, UserDTO.class);
	}

	public User convertToModel(UserDTO source) {
		return super.convertToModel(source, User.class);
	}
	
}
