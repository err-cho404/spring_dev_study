package com.springmvc.books.service;

import java.util.List;

import com.springmvc.domain.Book;

public interface BookService {
	int insertBookService(Book book);
	int delBookService(String bookId);
	List<Book> getAllBookList();
	List<Book> getBookOne(String bookId);
}
