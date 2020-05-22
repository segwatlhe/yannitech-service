package com.yannitech.bookstore.yannitech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yannitech.bookstore.yannitech.model.Book;


public interface BookSearchRepository extends JpaRepository<Book, Long> {

	List<Book> findByTitleContaining(String title);
}
