package com.mvc.converter;

import java.util.List;

import org.mapstruct.Mapper;

import com.mvc.model.User;
import com.mvc.model.dto.UserDTO;
import org.mapstruct.Mapping;

@Mapper(uses = AddressMapper.class)
public interface UserMapper {

	UserDTO toUserDto(User one);
	
	@Mapping(target = "rents", ignore = true)
	User toUser(UserDTO one);

	List<UserDTO> toUserDto(List<User> users);
	
	List<User> toUser(List<UserDTO> users);

}
