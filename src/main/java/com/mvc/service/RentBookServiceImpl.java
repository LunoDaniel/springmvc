package com.mvc.service;

import static org.springframework.util.ObjectUtils.isEmpty;
import static org.thymeleaf.util.ListUtils.isEmpty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.converter.UserConverter;
import com.mvc.exceptions.BusinessException;
import com.mvc.model.dto.RentBookDTO;
import com.mvc.repository.DateRepository;
import com.mvc.repository.RentBookRepository;

@Service
public class RentBookServiceImpl implements RentBookService {
	
	@Autowired RentBookRepository repository;
	@Autowired RentBookConverter converter;
	@Autowired DateRepository dates;
	@Autowired UserConverter userConverter;

	@Override
	public List<RentBookDTO> rentBook(RentBookDTO rent) throws BusinessException {
		if (isEmpty(rent.getBooks()) || isEmpty(rent.getUser())) {
			throw new BusinessException();
		}
		rent.setRentalDate(dates.current());

		try {
			repository.save(converter.convert(rent));
		} catch (Exception e) {
			throw new BusinessException();
		}

		return converter.convertToListDTO(repository.findAllRentByUser(userConverter.convert(rent.getUser())));
	}

}
