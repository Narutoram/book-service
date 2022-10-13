package com.digitalbooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.dto.BookDto;
import com.digitalbooks.entity.BookEntity;
import com.digitalbooks.service.BookService;

@RestController
@RequestMapping("/api/digitalbooks/author")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("{authorId}/books")
	public BookEntity createBook(@RequestBody BookDto book,@PathVariable Long authorId) {
		return bookService.createBook(book,authorId);
	}
	

	@PutMapping("/{authorId}/books/{bookId}")
	public BookEntity updateBook(@PathVariable(name="authorId") Long authorId,@PathVariable(name="bookId") Long bookId, BookDto book) {
		return bookService.updateBook(authorId,bookId,book);
	}
	

	@PostMapping("/{authorId}/books/{bookId}/isBlocked")
	public BookEntity isActive(@PathVariable Long authorId,@PathVariable Long bookId,@RequestParam Boolean isBlocked) {
		return bookService.isActive(authorId, bookId,isBlocked);
	}
	
	

}
