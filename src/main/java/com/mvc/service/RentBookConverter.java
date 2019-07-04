package com.mvc.service;

import org.springframework.stereotype.Component;

import com.mvc.converter.BaseConverter;
import com.mvc.model.RentBook;
import com.mvc.model.dto.RentBookDTO;

@Component
public class RentBookConverter extends BaseConverter<RentBookDTO, RentBook> {
	public RentBookDTO convertToDTO(RentBook source) {
		return super.convertToDTO(source, RentBookDTO.class);
	}

	public RentBook convertToModel(RentBookDTO source) {
		return super.convertToModel(source, RentBook.class);
	}
}
