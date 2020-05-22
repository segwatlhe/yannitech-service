package com.yannitech.bookstore.yannitech.repository;

import java.util.List;

import com.yannitech.bookstore.yannitech.model.Book;

public interface BookCustomRepository {

	Book findById(Long id);
	List<Book> findAll();
	Book findBookById(Long bookId);
	Book saveBook(Book book);
	Book updateBook(Book book);
	void delete(Book book);
}
