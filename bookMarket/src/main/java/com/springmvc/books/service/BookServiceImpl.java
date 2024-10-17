package com.springmvc.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.books.repository.BookRepository;
import com.springmvc.domain.Book;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookRepository bookRepository;
	@Override
	public int insertBookService(Book book) {
		return bookRepository.insertBook(book);
	}

	@Override
	public int delBookService(String bookId) {
		return bookRepository.delBook(bookId);
	}

	@Override
	public List<Book> getAllBookList() {
		return bookRepository.getBookList();
	}

	@Override
	public List<Book> getBookOne(String bookId) {
		return bookRepository.getSearchBook(bookId);
	}

}
