package com.digitalbooks.service;

import com.digitalbooks.dto.BookDto;
import com.digitalbooks.entity.BookEntity;

public interface BookService {

	BookEntity createBook(BookDto book, Long authorId);

	BookEntity updateBook(Long authorId, Long bookId, BookDto book);

	BookEntity isActive(Long authorId, Long bookId, Boolean isBlocked);

}
