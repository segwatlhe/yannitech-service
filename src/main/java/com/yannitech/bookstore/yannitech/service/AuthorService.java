package com.yannitech.bookstore.yannitech.service;

import com.yannitech.bookstore.yannitech.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAllByBook_Id(Long bookId);
    void removeAuthor(Long id);
    void addAuthor(Long bookId);
}
