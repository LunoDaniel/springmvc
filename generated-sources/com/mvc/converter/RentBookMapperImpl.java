package com.mvc.converter;

import com.mvc.model.Book;

import com.mvc.model.RentBook;

import com.mvc.model.dto.BookDTO;

import com.mvc.model.dto.RentBookDTO;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.mapstruct.factory.Mappers;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2019-10-17T13:44:50-0300",

    comments = "version: 1.1.0.Final, compiler: Eclipse JDT (IDE) 3.18.0.v20190522-0428, environment: Java 1.8.0_221 (Oracle Corporation)"

)

public class RentBookMapperImpl implements RentBookMapper {

    private final BookMapper bookMapper = Mappers.getMapper( BookMapper.class );

    private final UserMapper userMapper = Mappers.getMapper( UserMapper.class );

    @Override

    public RentBook toRentBook(RentBookDTO rent) {

        if ( rent == null ) {

            return null;
        }

        RentBook rentBook = new RentBook();

        List<Book> list = bookMapper.toBook( rent.getBooks() );

        if ( list != null ) {

            rentBook.setBooks( list );
        }

        rentBook.setId( rent.getId() );

        rentBook.setRentalDate( rent.getRentalDate() );

        rentBook.setReturnDate( rent.getReturnDate() );

        rentBook.setTotalRentValue( rent.getTotalRentValue() );

        rentBook.setUser( userMapper.toUser( rent.getUser() ) );

        return rentBook;
    }

    @Override

    public RentBookDTO toRentBook(RentBook rent) {

        if ( rent == null ) {

            return null;
        }

        RentBookDTO rentBookDTO = new RentBookDTO();

        List<BookDTO> list = bookMapper.toBookDto( rent.getBooks() );

        if ( list != null ) {

            rentBookDTO.setBooks( list );
        }

        rentBookDTO.setId( rent.getId() );

        rentBookDTO.setRentalDate( rent.getRentalDate() );

        rentBookDTO.setReturnDate( rent.getReturnDate() );

        rentBookDTO.setTotalRentValue( rent.getTotalRentValue() );

        rentBookDTO.setUser( userMapper.toUserDto( rent.getUser() ) );

        return rentBookDTO;
    }

    @Override

    public List<RentBookDTO> toRentBookDto(List<RentBook> rentsBook) {

        if ( rentsBook == null ) {

            return null;
        }

        List<RentBookDTO> list = new ArrayList<RentBookDTO>();

        for ( RentBook rentBook : rentsBook ) {

            list.add( toRentBook( rentBook ) );
        }

        return list;
    }
}

