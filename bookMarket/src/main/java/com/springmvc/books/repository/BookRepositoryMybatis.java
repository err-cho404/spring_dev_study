package com.springmvc.books.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Book;
@Repository
public class BookRepositoryMybatis implements BookRepository{
	
	@Autowired
	SqlSession session;
	
	@Override
	public int insertBook(Book book) {
		return session.update("com.springmvc.books.repository.BookRepository.insertBook",book);
	}
	
	@Override
	public int delBook(String bookId) {
		return session.update("com.springmvc.books.repository.BookRepository.delBook",bookId);
	}

	@Override
	public List<Book> getBookList() {
		return session.selectList("com.springmvc.books.repository.BookRepository.allBookList");
	}

	@Override
	public List<Book> getSearchBook(String bookId) {
		return session.selectList("com.springmvc.books.repository.BookRepository.getSearchBook",bookId);
	}
	
}
