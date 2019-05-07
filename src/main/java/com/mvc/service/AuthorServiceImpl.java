package com.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.converter.AuthorConverter;
import com.mvc.model.dto.AuthorDTO;
import com.mvc.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired private AuthorRepository repository;
	@Autowired private AuthorConverter converter;

	@Override
	public List<AuthorDTO> listAllAuthors() {
		return converter.convertToListDTO(repository.findAll());
	}

	@Override
	public AuthorDTO getAuthorById(Long id) {
		return converter.convertToDTO(repository.getOne(id));
	}
	
	

}
