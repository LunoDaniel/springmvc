package com.mvc.converter;

import com.mvc.model.Author;

import com.mvc.model.Book;

import com.mvc.model.dto.AuthorDTO;

import com.mvc.model.dto.BookDTO;

import com.mvc.model.dto.BookFTO;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.mapstruct.factory.Mappers;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2019-10-17T13:44:50-0300",

    comments = "version: 1.1.0.Final, compiler: Eclipse JDT (IDE) 3.18.0.v20190522-0428, environment: Java 1.8.0_221 (Oracle Corporation)"

)

public class BookMapperImpl implements BookMapper {

    private final AuthorMapper authorMapper = Mappers.getMapper( AuthorMapper.class );

    @Override

    public BookDTO toBookDto(Book book) {

        if ( book == null ) {

            return null;
        }

        BookDTO bookDTO = new BookDTO();

        List<AuthorDTO> list = authorMapper.toAuthorDto( book.getAuthors() );

        if ( list != null ) {

            bookDTO.setAuthors( list );
        }

        bookDTO.setId( book.getId() );

        bookDTO.setImage( book.getImage() );

        bookDTO.setReleaseDate( book.getReleaseDate() );

        bookDTO.setRented( book.getRented() );

        bookDTO.setResume( book.getResume() );

        bookDTO.setStockQuantity( book.getStockQuantity() );

        bookDTO.setTitle( book.getTitle() );

        bookDTO.setUnitPrice( book.getUnitPrice() );

        return bookDTO;
    }

    @Override

    public Book toBook(BookDTO book) {

        if ( book == null ) {

            return null;
        }

        Book book_ = new Book();

        book_.setId( book.getId() );

        List<Author> list = authorMapper.toAuthor( book.getAuthors() );

        if ( list != null ) {

            book_.setAuthors( list );
        }

        book_.setImage( book.getImage() );

        book_.setReleaseDate( book.getReleaseDate() );

        book_.setRented( book.getRented() );

        book_.setResume( book.getResume() );

        book_.setStockQuantity( book.getStockQuantity() );

        book_.setTitle( book.getTitle() );

        book_.setUnitPrice( book.getUnitPrice() );

        return book_;
    }

    @Override

    public List<BookDTO> toBookDto(List<Book> books) {

        if ( books == null ) {

            return null;
        }

        List<BookDTO> list = new ArrayList<BookDTO>();

        for ( Book book : books ) {

            list.add( toBookDto( book ) );
        }

        return list;
    }

    @Override

    public List<Book> toBook(List<BookDTO> books) {

        if ( books == null ) {

            return null;
        }

        List<Book> list = new ArrayList<Book>();

        for ( BookDTO bookDTO : books ) {

            list.add( toBook( bookDTO ) );
        }

        return list;
    }

    @Override

    public Book ftoToBook(BookFTO book) {

        if ( book == null ) {

            return null;
        }

        Book book_ = new Book();

        book_.setReleaseDate( book.getReleaseDate() );

        book_.setRented( book.getRented() );

        book_.setResume( book.getResume() );

        List<Author> list = authorMapper.toAuthor( authorMapper.toAuthorDtoById( book.getAuthors() ) );

        if ( list != null ) {

            book_.setAuthors( list );
        }

        book_.setId( book.getId() );

        book_.setTitle( book.getTitle() );

        book_.setStockQuantity( book.getQuantity() );

        book_.setImage( book.getImage() );

        return book_;
    }
}

