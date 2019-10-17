package com.mvc.converter;

import com.mvc.model.Address;

import com.mvc.model.dto.AddressDTO;

import javax.annotation.Generated;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2019-10-17T13:44:50-0300",

    comments = "version: 1.1.0.Final, compiler: Eclipse JDT (IDE) 3.18.0.v20190522-0428, environment: Java 1.8.0_221 (Oracle Corporation)"

)

public class AddressMapperImpl implements AddressMapper {

    @Override

    public AddressDTO toAddresDto(Address address) {

        if ( address == null ) {

            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setCity( address.getCity() );

        addressDTO.setState( address.getState() );

        addressDTO.setStreet( address.getStreet() );

        addressDTO.setZipCode( address.getZipCode() );

        return addressDTO;
    }

    @Override

    public Address toAddresDto(AddressDTO address) {

        if ( address == null ) {

            return null;
        }

        Address address_ = new Address();

        address_.setCity( address.getCity() );

        address_.setState( address.getState() );

        address_.setStreet( address.getStreet() );

        address_.setZipCode( address.getZipCode() );

        return address_;
    }
}

