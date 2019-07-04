package com.mvc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.model.RentBook;
import com.mvc.model.dto.RentBookDTO;
import com.mvc.service.BooksService;
import com.mvc.service.RentBookService;
import com.mvc.service.UsersService;

@Controller
@RequestMapping("/rent-books")
public class RentBookController {
	
	@Autowired private UsersService userService;
	@Autowired private BooksService bookService;
	@Autowired private RentBookService rentBookService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public void rentBookPage(Model model) {
		model.addAttribute("rentBook", new RentBookDTO());
		model.addAttribute("listOfBooks", bookService.findAllBooks());
	}

	@RequestMapping(value = "/rent", method = RequestMethod.POST)
	public String rentBook(@Valid RentBook rent, Model model, BindingResult result) {

		return null;
	}

}
