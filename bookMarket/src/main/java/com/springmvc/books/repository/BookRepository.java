package com.springmvc.books.repository;

import java.util.List;

import com.springmvc.domain.Book;

public interface BookRepository {
	int insertBook(Book book);
	int delBook(String bookId);
	List<Book> getBookList();
	List<Book> getSearchBook(String bookId);
}
