package com.library.mockService.Entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private BookRepository repo;

	public List<Books> listAll() {

		return repo.findAll();
	}
}
