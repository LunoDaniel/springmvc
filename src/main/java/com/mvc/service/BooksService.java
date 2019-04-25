package com.mvc.service;

import java.util.List;

import javax.validation.Valid;

import com.mvc.exceptions.BusinessException;
import com.mvc.model.dto.BookDTO;

public interface BooksService {

	public BookDTO findUserById(Long id);
	public List<BookDTO> findAllUsers();
	public BookDTO saveBook(@Valid BookDTO user) throws BusinessException;

}
