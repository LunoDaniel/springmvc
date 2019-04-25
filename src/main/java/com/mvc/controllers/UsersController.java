package com.mvc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.exceptions.BusinessException;
import com.mvc.exceptions.CpfException;
import com.mvc.model.dto.UserDTO;
import com.mvc.service.UsersService;
import com.mvc.validator.UserValidator;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	@Autowired private UserValidator validator;
	@Autowired private UsersService service;
	
	private static final String PATH = "/users/users-form";
	private static final String LIST = "/users/users-list";
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	private static final String CPF_INVALID = "cpfInvalid";
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validator);
	}
	
	@RequestMapping
	public ModelAndView viewUser(Model model) {
		emptyModelObject(model);
		model.addAttribute(SUCCESS, false);
		return new ModelAndView(PATH);
	}
	
	@RequestMapping("/list")
	public ModelAndView listUser(Model model) {
		model.addAttribute("users", service.findAllUsers());
		return new ModelAndView(LIST);
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("user") @Valid UserDTO user,
			BindingResult result, Model model) throws BusinessException {
		
		if(result.hasErrors()) {
			return new ModelAndView(PATH);
		}
		
		try {
			service.saveUser(user);
			emptyModelObject(model);
			model.addAttribute(SUCCESS, true);
		} catch(CpfException except) {
			model.addAttribute(ERROR, true);
			model.addAttribute(CPF_INVALID, true);
		} catch (BusinessException except) {
			model.addAttribute(ERROR, true);
		}
		
		return new ModelAndView(PATH);
	} 
	
	private void emptyModelObject(Model model) {
		model.addAttribute("user", new UserDTO());
	}
}
