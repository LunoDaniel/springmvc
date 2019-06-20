package com.mvc.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.model.dto.BookDTO;

@RestController
@RequestMapping("/api")
public interface ResourceApi {

	@RequestMapping("/books")
	public ResponseEntity<List<BookDTO>> listOfBooks();
}
