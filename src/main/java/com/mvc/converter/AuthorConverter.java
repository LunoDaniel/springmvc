package com.mvc.converter;

import org.springframework.stereotype.Component;

import com.mvc.model.Author;
import com.mvc.model.dto.AuthorDTO;

@Component
public class AuthorConverter extends BaseConverter<AuthorDTO, Author>{
	
	public AuthorDTO convertToDTO(Author source) {
		return super.convertToDTO(source, AuthorDTO.class);
	}

	public Author convertToModel(AuthorDTO source) {
		return super.convertToModel(source, Author.class);
	}
}
