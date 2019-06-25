package com.mvc.resources;

import static org.springframework.util.ObjectUtils.isEmpty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.model.dto.BookDTO;
import com.mvc.resources.api.BookResourceApi;
import com.mvc.service.BooksService;

@RestController
public class BookResource implements BookResourceApi {
	
	@Autowired private BooksService bookService;

	@Override
	public ResponseEntity<List<BookDTO>> listOfBooks() {
		List<BookDTO> books = bookService.findAllBooks();
		
		if(isEmpty(books) || books.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(books);
	}

}
