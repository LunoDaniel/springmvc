package com.mvc.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
import com.mvc.model.dto.BookFTO;
import com.mvc.service.AuthorService;
import com.mvc.service.BooksService;
import com.mvc.validator.BookValidator;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired private BooksService service;
	@Autowired private AuthorService authorService;
	@Autowired private BookValidator validator;
	
	private static final String FORM = "/books/books-form";
	private static final String LIST = "/books/books-list";
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	private static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	    binder.registerCustomEditor(Date.class, editor);
	    
		binder.addValidators(validator);
	}
	
	@RequestMapping
	public ModelAndView viewBook(Model model) {
		emptyModelObject(model);
		model.addAttribute(SUCCESS, false);
		return new ModelAndView(FORM);
	}
	
	@RequestMapping("/list")
	public ModelAndView listBook(Model model) {
		return new ModelAndView(LIST);
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveBook(@ModelAttribute("book") @Valid BookFTO book,
			BindingResult result, Model model) throws BusinessException {
		
		if(result.hasErrors()) {
			model.addAttribute("authorsList", authorService.listAllAuthors());
			return new ModelAndView(FORM);
		}
		
		try {
			service.saveBook(book);
			emptyModelObject(model);
			model.addAttribute(SUCCESS, true);
		} catch (BusinessException except) {
			model.addAttribute(ERROR, true);
		}
		
		return new ModelAndView(FORM);
	} 
	

	private void emptyModelObject(Model model) {
		model.addAttribute("book", new BookFTO());
		model.addAttribute("authorsList", authorService.listAllAuthors());
	}
}
