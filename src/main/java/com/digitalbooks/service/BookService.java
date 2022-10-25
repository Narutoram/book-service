package com.digitalbooks.service;

import java.util.List;

import com.digitalbooks.dto.BookDto;
import com.digitalbooks.entity.BookEntity;

public interface BookService {

	BookEntity createBook(BookDto book, Long authorId);

	BookEntity updateBook(Long authorId, Long bookId, BookDto book);

	BookEntity blockOrUnblockBooks(Long authorId, Long bookId, Boolean block);

	BookEntity fetchBookById(Long bookId);

	List<BookDto> fetchAllBoks(Long bookId);

}
