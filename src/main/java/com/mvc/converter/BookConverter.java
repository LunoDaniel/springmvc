package com.mvc.converter;

import org.springframework.stereotype.Component;

import com.mvc.model.Book;
import com.mvc.model.dto.BookDTO;

@Component
public class BookConverter extends BaseConverter<BookDTO, Book>{
	
	public BookDTO convertToDTO(Book source) {
		return super.convertToDTO(source, BookDTO.class);
	}

	public Book convertToModel(BookDTO source) {
		return super.convertToModel(source, Book.class);
	}
}
