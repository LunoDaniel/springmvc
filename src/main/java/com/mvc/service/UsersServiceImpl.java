package com.mvc.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.converter.UserConverter;
import com.mvc.exceptions.BusinessException;
import com.mvc.exceptions.CpfException;
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
		public UserDTO saveUser(UserDTO user) throws BusinessException {
		User newUser = converter.convert(user, User.class);
		try {
			return converter.convert(repository.save(newUser));
		} catch (ConstraintViolationException e) {
			throw new CpfException();
		}
	}
}
