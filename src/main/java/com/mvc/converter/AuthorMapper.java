package com.mvc.converter;

import java.util.List;

import org.mapstruct.Mapper;

import com.mvc.model.Author;
import com.mvc.model.dto.AuthorDTO;
import com.mvc.service.AuthorService;

@Mapper(componentModel = "spring", uses = {BookMapper.class, AuthorService.class})
public interface AuthorMapper {
	
	AuthorDTO toAuthorDto(Author author);
	
	Author toAuthor(AuthorDTO author);
	
	List<AuthorDTO> toAuthorDto(List<Author> authors);
	
	List<Author> toAuthor(List<AuthorDTO> authors);
	
	List<AuthorDTO> toAuthorDtoById(List<Long> authors);
}
