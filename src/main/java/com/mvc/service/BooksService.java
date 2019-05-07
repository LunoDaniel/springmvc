package com.mvc.service;

import java.util.List;

import javax.validation.Valid;

import com.mvc.exceptions.BusinessException;
import com.mvc.model.dto.BookDTO;
import com.mvc.model.dto.BookFTO;

public interface BooksService {

	public BookDTO findUserById(Long id);
	public List<BookDTO> findAllBooks();
	public BookDTO saveBook(@Valid BookFTO user) throws BusinessException;

}
