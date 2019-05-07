package com.mvc.service;

import java.util.List;

import com.mvc.model.dto.AuthorDTO;

public interface AuthorService {
	public List<AuthorDTO> listAllAuthors();
	public AuthorDTO getAuthorById(Long id);
}
