package com.mvc.service;

import static org.springframework.util.ObjectUtils.isEmpty;
import static org.thymeleaf.util.ListUtils.isEmpty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.converter.RentBookMapper;
import com.mvc.converter.UserMapper;
import com.mvc.exceptions.BusinessException;
import com.mvc.model.dto.RentBookDTO;
import com.mvc.model.repository.DateRepository;
import com.mvc.model.repository.RentBookRepository;

@Service
public class RentBookServiceImpl implements RentBookService {
	
	@Autowired RentBookRepository repository;
	@Autowired RentBookMapper converter;
	@Autowired DateRepository dates;
	@Autowired UserMapper userConverter;

	@Override
	public List<RentBookDTO> rentBook(RentBookDTO rent) throws BusinessException {
		if (isEmpty(rent.getBooks()) || isEmpty(rent.getUser())) {
			throw new BusinessException();
		}
		rent.setRentalDate(dates.current());

		try {
			repository.save(converter.toRentBook(rent));
		} catch (Exception e) {
			throw new BusinessException();
		}

		return converter.toRentBookDto(repository.findAllRentByUser(userConverter.toUser(rent.getUser())));
	}

}
