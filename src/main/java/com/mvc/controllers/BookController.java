package com.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.model.dto.UserDTO;

@Controller
@RequestMapping("/books")
public class BookController {
	
	private static final String PATH = "/books/form";
	private static final String LIST = "/books/list";
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	}
	
	@RequestMapping
	public ModelAndView viewUser(Model model) {
		emptyModelObject(model);
		model.addAttribute(SUCCESS, false);
		return new ModelAndView(PATH);
	}
	
	@RequestMapping("/list")
	public ModelAndView listUser(Model model) {
		model.addAttribute("users", null);
		return new ModelAndView(LIST);
	}
	

	private void emptyModelObject(Model model) {
		model.addAttribute("book", new UserDTO());
	}
}
