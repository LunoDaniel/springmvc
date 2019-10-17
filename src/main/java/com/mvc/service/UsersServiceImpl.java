package com.mvc.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.converter.UserMapper;
import com.mvc.exceptions.BusinessException;
import com.mvc.exceptions.CpfException;
import com.mvc.model.User;
import com.mvc.model.dto.UserDTO;
import com.mvc.model.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired private UsersRepository repository;
	@Autowired private UserMapper converter;
	
	@Override
	public UserDTO findUserById(Long id) {
		return converter.toUserDto(repository.getOne(id));
	}
	
	@Override
	public List<UserDTO> findAllUsers() {
		return converter.toUserDto(repository.findAll());
	}
	
	@Override
	public UserDTO saveUser(UserDTO user) throws BusinessException {
		User newUser = converter.toUser(user);
		try {
			return converter.toUserDto(repository.save(newUser));
		} catch (ConstraintViolationException e) {
			throw new CpfException();
		}
	}
}
