package com.mvc.converter;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mvc.model.Book;
import com.mvc.model.dto.BookDTO;
import com.mvc.model.dto.BookFTO;
import com.mvc.service.AuthorService;

@Component
public class BookConverter extends BaseConverter<BookDTO, Book>{
	
	@Autowired private AuthorService authors;
	
	public BookDTO convertToDTO(Book source) {
		return super.convertToDTO(source, BookDTO.class);
	}

	public Book convertToModel(BookDTO source) {
		return super.convertToModel(source, Book.class);
	}
	
	public Book convertToModel(BookFTO source) {
		BookDTO target = new BookDTO();
		BeanUtils.copyProperties(source, target);
		target.setAuthors(new ArrayList<>());
		setAuthros(source, target);
		
		return super.convertToModel(target, Book.class);
	}
	
	private void setAuthros(BookFTO source, BookDTO target) {
		source.getAuthors().forEach( idAuthor -> target.getAuthors().add(authors.getAuthorById(idAuthor)));
	}
	
}
