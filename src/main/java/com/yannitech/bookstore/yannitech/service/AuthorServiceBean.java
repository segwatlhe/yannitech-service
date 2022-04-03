package com.yannitech.bookstore.yannitech.service;

import com.yannitech.bookstore.yannitech.model.Author;
import com.yannitech.bookstore.yannitech.model.Book;
import com.yannitech.bookstore.yannitech.repository.AuthorRepository;
import com.yannitech.bookstore.yannitech.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorServiceBean implements AuthorService{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorServiceBean(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Author> findAllByBook_Id(Long bookId) {
        return authorRepository.findAllByBook_Id(bookId);
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public void removeAuthor(Long id) {
      //  authorRepository.delete(author);
    }

    @Override
    @Transactional
    public void addAuthor(Author author) {
        Book book = bookRepository.findById(author.getId());
        author.setBook(book);
        authorRepository.save(author);
    }
}
