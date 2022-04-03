package com.yannitech.bookstore.yannitech.service;

import com.yannitech.bookstore.yannitech.model.Book;

import java.util.List;

public interface BookService {
    Book findById(Long id);
    List<Book> findAll();
    Book saveBook(Book book);
    void updateBook(Book book, Long id);
    void delete(Book book);
    void deleteById(Long bookId);
}
