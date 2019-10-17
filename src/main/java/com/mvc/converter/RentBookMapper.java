package com.mvc.converter;

import java.util.List;

import org.mapstruct.Mapper;

import com.mvc.model.RentBook;
import com.mvc.model.dto.RentBookDTO;

@Mapper(uses = {BookMapper.class, UserMapper.class})
public interface RentBookMapper {

	RentBook toRentBook(RentBookDTO rent);
	
	RentBookDTO toRentBook(RentBook rent);
	
	List<RentBookDTO> toRentBookDto(List<RentBook> rentsBook);
}
