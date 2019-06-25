package com.mvc.resources.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.model.dto.BookDTO;

@RequestMapping("/api")
public interface BookResourceApi {

	@GetMapping(path = "/books", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<BookDTO>> listOfBooks();
}
