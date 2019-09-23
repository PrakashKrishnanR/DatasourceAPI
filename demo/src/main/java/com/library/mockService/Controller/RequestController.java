package com.library.mockService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.mockService.Entity.BookService;
import com.library.mockService.Entity.Books;

@RestController
public class RequestController {

	@Autowired
	private BookService booksService;

	@GetMapping("/all")
	public List<Books> viewAllBooks() {
		System.out.println(booksService.listAll());
		return booksService.listAll();
	}

}
