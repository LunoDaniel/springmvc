package com.mvc.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mvc.model.Book;
import com.mvc.model.dto.BookDTO;

@Component
public class BookConverter implements Converter<Book, BookDTO>{

	@Override
	public BookDTO convert(Book source) {
		// TODO Auto-generated method stub
		return null;
	}

}
