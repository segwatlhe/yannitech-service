package com.yannitech.bookstore.yannitech.service;

import com.yannitech.bookstore.yannitech.model.Book;

import java.util.List;

public interface BookService {
    Book findById(Long id);
    List<Book> findAll();
    Book saveBook(Book book);
    void editBook(Book book, Long id);
    void deleteById(Long bookId);
}
