package com.digitalbooks.service;

import java.util.List;

import org.modelmapper.ModelMapper;
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

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BookEntity createBook(BookDto book, Long authorId) {
		BookEntity bookEntity = new BookEntity();
		bookEntity.setTitle(book.getTitle());
		bookEntity.setCategory(book.getCategory());
		bookEntity.setPrice(book.getPrice());
		bookEntity.setPublisher(book.getPublisher());
		bookEntity.setPubDate(book.getPubDate());
		bookEntity.setContent(book.getContent());
		bookEntity.setIsActive(Boolean.TRUE);
		bookEntity.setAuthorId(authorId);
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
		result.setAuthorId(authorId);
		return bookDao.save(result);

	}

	@Override
	public BookEntity blockOrUnblockBooks(Long authorId, Long bookId, Boolean block) {
		// authorId check this id is the author type
		BookEntity book = bookDao.findById(bookId).get();
		book.setIsActive(block);
		return bookDao.save(book);
	}

	@Override
	public BookEntity fetchBookById(Long bookId) {
		return bookDao.findById(bookId).get();
	}

	@Override
	public List<BookDto> fetchAllBoks(Long bookId) {
		List<BookEntity> books=bookDao.findAll();
		return entityToDtoConversion(books);
	}

	@SuppressWarnings("unchecked")
	private List<BookDto> entityToDtoConversion(List<BookEntity> book) {
		return (List<BookDto>) modelMapper.map(book, BookDto.class);
	}

}
