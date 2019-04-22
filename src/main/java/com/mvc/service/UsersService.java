package com.mvc.service;

import java.util.List;

import com.mvc.exceptions.BusinessException;
import com.mvc.model.dto.UserDTO;

public interface UsersService {
	public UserDTO findUserById(Long id);
	public List<UserDTO> findAllUsers();
	public UserDTO saveUser(UserDTO user) throws BusinessException;
}
