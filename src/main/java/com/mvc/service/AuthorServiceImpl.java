package com.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.converter.AuthorMapper;
import com.mvc.model.dto.AuthorDTO;
import com.mvc.model.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired private AuthorRepository repository;
	@Autowired private AuthorMapper converter;

	@Override
	public List<AuthorDTO> listAllAuthors() {
	//	return converter.convertToListDTO(repository.findAll());
		return new ArrayList<>();
	}

	@Override
	public AuthorDTO getAuthorById(Long id) {
		return converter.toAuthorDto(repository.getOne(id));
	}
	
	

}
