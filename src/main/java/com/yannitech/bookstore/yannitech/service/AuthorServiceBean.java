package com.yannitech.bookstore.yannitech.service;

import com.yannitech.bookstore.yannitech.model.Author;
import com.yannitech.bookstore.yannitech.model.Book;
import com.yannitech.bookstore.yannitech.repository.AuthorRepository;
import com.yannitech.bookstore.yannitech.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceBean implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorServiceBean(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Author> findAllByBook_Id(Long bookId) {
        List<Author> authors = authorRepository.findAllByBook_Id(bookId);
        return authors;
    }

    @Override
    public void remove(Long id) {
        Author author = authorRepository.findById(id);
        author.setBook(null);
        authorRepository.delete(author);
    }

    @Override
    public void save(Long bookId, Author author) {
        Book book = bookRepository.findById(bookId);
        Author newAuthor = new Author();
        newAuthor.setAuthorName(author.getAuthorName());
        newAuthor.setBook(book);
        authorRepository.save(newAuthor);
    }
}
