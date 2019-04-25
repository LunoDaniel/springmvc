package com.mvc.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class BaseConverter<T, S> implements Converter<T, S> {

	@Autowired private ModelMapper mapper;
	
	public List<S> convertToListModel(List<T> all){
		List<S> dtoList = new ArrayList<>();
		
		all.forEach(item -> dtoList.add(convertToModel(item, item.getClass())));
		
		return dtoList;
	}
	
	public List<T> convertToListDTO(List<S> all){
		List<T> dtoList = new ArrayList<>();
		
		all.forEach(item -> dtoList.add(convertToDTO(item, item.getClass())));
		
		return dtoList;
	}
	
	@SuppressWarnings("unchecked")
	public T convertToDTO(S source, Class<? extends Object> clazz) {
		return (T) mapper.map(source, clazz);
	}
	
	@SuppressWarnings("unchecked")
	public S convertToModel(T source, Class<? extends Object> clazz) {
		return (S) mapper.map(source, clazz);
	}
	
	@Override
	public S convert(T source) {
		return null;
	}
}
