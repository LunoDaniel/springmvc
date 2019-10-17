package com.mvc.converter;

import org.mapstruct.Mapper;

import com.mvc.model.Address;
import com.mvc.model.dto.AddressDTO;

@Mapper
public interface AddressMapper {
	
	AddressDTO toAddresDto(Address address);
	
	Address toAddresDto(AddressDTO address);
}
