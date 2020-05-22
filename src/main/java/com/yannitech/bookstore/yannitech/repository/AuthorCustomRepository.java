package com.yannitech.bookstore.yannitech.repository;

import java.util.List;

import com.yannitech.bookstore.yannitech.model.Author;

public interface AuthorCustomRepository {

	List<Author> findAuthorsByBookId(Long bookId);
	Author findAuthorById(Long id);
	void removeAuthor(Author author);
	Author findAuthorByBookId(Long bookId);
	void updateAuthor(Author author);
}
