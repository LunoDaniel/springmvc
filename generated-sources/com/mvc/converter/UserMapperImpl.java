package com.mvc.converter;

import com.mvc.model.User;

import com.mvc.model.dto.UserDTO;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.mapstruct.factory.Mappers;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2019-10-17T13:44:50-0300",

    comments = "version: 1.1.0.Final, compiler: Eclipse JDT (IDE) 3.18.0.v20190522-0428, environment: Java 1.8.0_221 (Oracle Corporation)"

)

public class UserMapperImpl implements UserMapper {

    private final AddressMapper addressMapper = Mappers.getMapper( AddressMapper.class );

    @Override

    public UserDTO toUserDto(User one) {

        if ( one == null ) {

            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setAddress( addressMapper.toAddresDto( one.getAddress() ) );

        userDTO.setChecked( one.getChecked() );

        userDTO.setCpf( one.getCpf() );

        userDTO.setEmail( one.getEmail() );

        userDTO.setId( one.getId() );

        userDTO.setName( one.getName() );

        userDTO.setPassword( one.getPassword() );

        return userDTO;
    }

    @Override

    public User toUser(UserDTO one) {

        if ( one == null ) {

            return null;
        }

        User user = new User();

        user.setId( one.getId() );

        user.setAddress( addressMapper.toAddresDto( one.getAddress() ) );

        user.setChecked( one.getChecked() );

        user.setCpf( one.getCpf() );

        user.setEmail( one.getEmail() );

        user.setName( one.getName() );

        user.setPassword( one.getPassword() );

        return user;
    }

    @Override

    public List<UserDTO> toUserDto(List<User> users) {

        if ( users == null ) {

            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>();

        for ( User user : users ) {

            list.add( toUserDto( user ) );
        }

        return list;
    }

    @Override

    public List<User> toUser(List<UserDTO> users) {

        if ( users == null ) {

            return null;
        }

        List<User> list = new ArrayList<User>();

        for ( UserDTO userDTO : users ) {

            list.add( toUser( userDTO ) );
        }

        return list;
    }
}

