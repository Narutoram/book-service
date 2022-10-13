package com.digitalbooks.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalbooks.dto.BookDto;
import com.digitalbooks.entity.BookEntity;
import com.digitalbooks.exception.DigitalbooksNotFoundException;
import com.digitalbooks.repository.BookDao;


@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;

	@Override
	public BookEntity createBook(BookDto book, Long authorId) {
		BookEntity bookEntity = new BookEntity();
		bookEntity.setTitle(book.getTitle());
		bookEntity.setCategory(book.getCategory());
		bookEntity.setPrice(book.getPrice());
		bookEntity.setPublisher(book.getPublisher());
		bookEntity.setPubDate(book.getPubDate());
		bookEntity.setContent(book.getContent());
		bookEntity.setIsActive(book.getIsActive());
		return bookDao.save(bookEntity);
	}

	@Override
	public BookEntity updateBook(Long authorId, Long bookId, BookDto book) {
		BookEntity result = bookDao.findById(bookId).orElse(null);
		if (result == null) {
			throw new DigitalbooksNotFoundException("Book Id: " + bookId + " doesn't exist");
		}
		result.setTitle(book.getTitle());
		result.setCategory(book.getCategory());
		result.setPrice(book.getPrice());
		result.setPublisher(book.getPublisher());
		result.setPubDate(book.getPubDate());
		result.setContent(book.getContent());
		result.setIsActive(book.getIsActive());
		return bookDao.save(result);
	
	}

	@Override
	public BookEntity isActive(Long authorId, Long bookId, Boolean isBlocked) {
		BookEntity book = bookDao.findById(bookId).get();
		book.setIsActive(isBlocked);
		return bookDao.save(book);
	}
			

}
