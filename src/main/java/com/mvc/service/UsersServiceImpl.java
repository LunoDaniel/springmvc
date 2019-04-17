package com.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.converter.UserConverter;
import com.mvc.model.User;
import com.mvc.model.dto.UserDTO;
import com.mvc.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired private UsersRepository repository;
	@Autowired private UserConverter converter;
	
	@Override
	public UserDTO findUserById(Long id) {
		return converter.convert(repository.getOne(id));
	}
	
	@Override
	public List<UserDTO> findAllUsers() {
		return converter.convertTotList(repository.findAll());
	}
	
	@Override
	public UserDTO saveUser(UserDTO user) {
		User newUser = converter.convert(user, User.class);
		return converter.convert(repository.save(newUser));
	}

}
