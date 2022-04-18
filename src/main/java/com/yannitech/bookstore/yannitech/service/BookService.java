package com.yannitech.bookstore.yannitech.service;

import com.yannitech.bookstore.yannitech.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    Book findById(Long id);
    List<Book> findAll();
    Book saveBook(Book book);
    void editBook(Book book, Long id);
    void deleteBook(Long bookId);
    Page<Book> findAllByTitleContainingIgnoreCase(Pageable pageable, String title);
}
