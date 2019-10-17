package com.mvc.converter;

import com.mvc.model.Author;

import com.mvc.model.Book;

import com.mvc.model.dto.AuthorDTO;

import com.mvc.model.dto.BookDTO;

import com.mvc.service.AuthorService;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2019-10-17T13:44:50-0300",

    comments = "version: 1.1.0.Final, compiler: Eclipse JDT (IDE) 3.18.0.v20190522-0428, environment: Java 1.8.0_221 (Oracle Corporation)"

)

@Component

public class AuthorMapperImpl implements AuthorMapper {

    @Autowired

    private BookMapper bookMapper;

    @Autowired

    private AuthorService authorService;

    @Override

    public AuthorDTO toAuthorDto(Author author) {

        if ( author == null ) {

            return null;
        }

        AuthorDTO authorDTO = new AuthorDTO();

        List<BookDTO> list = bookMapper.toBookDto( author.getBooks() );

        if ( list != null ) {

            authorDTO.setBooks( list );
        }

        authorDTO.setId( author.getId() );

        authorDTO.setName( author.getName() );

        return authorDTO;
    }

    @Override

    public Author toAuthor(AuthorDTO author) {

        if ( author == null ) {

            return null;
        }

        Author author_ = new Author();

        author_.setId( author.getId() );

        List<Book> list = bookMapper.toBook( author.getBooks() );

        if ( list != null ) {

            author_.setBooks( list );
        }

        author_.setName( author.getName() );

        return author_;
    }

    @Override

    public List<AuthorDTO> toAuthorDto(List<Author> authors) {

        if ( authors == null ) {

            return null;
        }

        List<AuthorDTO> list = authorService.listAllAuthors();

        for ( Author author : authors ) {

            list.add( toAuthorDto( author ) );
        }

        return list;
    }

    @Override

    public List<Author> toAuthor(List<AuthorDTO> authors) {

        if ( authors == null ) {

            return null;
        }

        List<Author> list = new ArrayList<Author>();

        for ( AuthorDTO authorDTO : authors ) {

            list.add( toAuthor( authorDTO ) );
        }

        return list;
    }

    @Override

    public List<AuthorDTO> toAuthorDtoById(List<Long> authors) {

        if ( authors == null ) {

            return null;
        }

        List<AuthorDTO> list = authorService.listAllAuthors();

        for ( Long long_ : authors ) {

            list.add( authorService.getAuthorById( long_ ) );
        }

        return list;
    }
}

