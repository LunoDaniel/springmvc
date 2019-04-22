package com.mvc.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mvc.model.User;
import com.mvc.model.dto.UserDTO;

@Component
public class UserConverter implements Converter<User, UserDTO> {
	
	@Autowired private ModelMapper mapper;
	
	public <T, S> List<T> convertTotList(List<S> all){
		List<T> dtoList = new ArrayList<>();
		
		all.forEach(item -> dtoList.add(convert(item, item.getClass())));
		
		return dtoList;
	}
	
	@SuppressWarnings("unchecked")
	public <T, S> T convert(S source, Class<? extends Object> clazz) {
		return (T) mapper.map(source, clazz);
	}

	@Override
	public UserDTO convert(User source) {
		return null;
	}
}
