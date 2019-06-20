package com.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.model.dto.BookDTO;
import com.mvc.service.BooksService;

@RestController
public class BookResource implements ResourceApi {
	
	@Autowired private BooksService bookService;

	@Override
	public ResponseEntity<List<BookDTO>> listOfBooks() {
		return ResponseEntity.ok(bookService.findAllBooks());
	}

}
