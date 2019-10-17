package com.mvc.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.converter.BookMapper;
import com.mvc.exceptions.BusinessException;
import com.mvc.model.Book;
import com.mvc.model.dto.BookDTO;
import com.mvc.model.dto.BookFTO;
import com.mvc.model.repository.BooksRepository;

@Service
public class BooksServiceImpl implements BooksService {
	
	@Autowired private BooksRepository repository;
	@Autowired private BookMapper converter;

	@Override
	public BookDTO findUserById(Long id) {
		return converter.toBookDto(repository.getOne(id));
	}

	@Override
	public List<BookDTO> findAllBooks() {
		return converter.toBookDto(repository.findAll());
	}

	@Override
	public BookDTO saveBook(@Valid BookFTO book) throws BusinessException {
		Book newBook = new Book();
		newBook = converter.ftoToBook(book);
		return converter.toBookDto(repository.save(newBook));
	}

}
