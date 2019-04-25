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
import com.mvc.model.dto.BookDTO;
import com.mvc.service.AuthorService;
import com.mvc.service.BooksService;
import com.mvc.validator.BookValidator;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired private BooksService service;
	@Autowired private AuthorService authorService;
	@Autowired private BookValidator validator;
	
	private static final String PATH = "/books/books-form";
	private static final String LIST = "/books/books-list";
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validator);
	}
	
	@RequestMapping
	public ModelAndView viewBook(Model model) {
		emptyModelObject(model);
		model.addAttribute(SUCCESS, false);
		return new ModelAndView(PATH);
	}
	
	@RequestMapping("/list")
	public ModelAndView listBook(Model model) {
		model.addAttribute("books", null);
		return new ModelAndView(LIST);
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveBook(@ModelAttribute("book") @Valid BookDTO book,
			BindingResult result, Model model) throws BusinessException {
		
		if(result.hasErrors()) {
			return new ModelAndView(PATH);
		}
		
		try {
			service.saveBook(book);
			emptyModelObject(model);
			model.addAttribute(SUCCESS, true);
		} catch (BusinessException except) {
			model.addAttribute(ERROR, true);
		}
		
		return new ModelAndView(PATH);
	} 
	

	private void emptyModelObject(Model model) {
		model.addAttribute("book", new BookDTO());
		model.addAttribute("authorsList", authorService.listAllAuthors());
	}
}
