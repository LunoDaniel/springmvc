package com.mvc.service;

import java.util.List;

import com.mvc.exceptions.BusinessException;
import com.mvc.model.dto.RentBookDTO;

public interface RentBookService {
	public List<RentBookDTO> rentBook(RentBookDTO rent) throws BusinessException;
}
