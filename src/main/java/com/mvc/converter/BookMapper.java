package com.mvc.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.mvc.model.Book;
import com.mvc.model.dto.BookDTO;
import com.mvc.model.dto.BookFTO;

@Mapper(uses = AuthorMapper.class)
public interface BookMapper {

	BookDTO toBookDto(Book book);

	Book toBook(BookDTO book);

	List<BookDTO> toBookDto(List<Book> books);

	List<Book> toBook(List<BookDTO> books);

	@Mappings({ @Mapping(source = "id", target = "book.id"), @Mapping(source = "title", target = "book.title"),
			@Mapping(source = "authors", target = "book.authors"),
			@Mapping(source = "releaseDate", target = "book.releaseDate"),
			@Mapping(source = "resume", target = "book.resume"), @Mapping(source = "rented", target = "book.rented"),
			@Mapping(target = "unitPrice", ignore = true),
			@Mapping(source = "quantity", target = "book.stockQuantity") })
	Book ftoToBook(BookFTO book);

}
