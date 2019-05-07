package com.mvc.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.converter.BookConverter;
import com.mvc.exceptions.BusinessException;
import com.mvc.model.Book;
import com.mvc.model.dto.BookDTO;
import com.mvc.model.dto.BookFTO;
import com.mvc.repository.BooksRepository;

@Service
public class BooksServiceImpl implements BooksService {
	
	@Autowired private BooksRepository repository;
	@Autowired private BookConverter converter;

	@Override
	public BookDTO findUserById(Long id) {
		return converter.convertToDTO(repository.getOne(id), BookDTO.class);
	}

	@Override
	public List<BookDTO> findAllBooks() {
		return converter.convertToListDTO(repository.findAll());
	}

	@Override
	public BookDTO saveBook(@Valid BookFTO book) throws BusinessException {
		Book newBook = new Book();
		newBook = converter.convertToModel(book);
		return converter.convertToDTO(repository.save(newBook));
	}

}
