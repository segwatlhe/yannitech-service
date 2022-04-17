package com.yannitech.bookstore.yannitech.service;

import com.yannitech.bookstore.yannitech.model.Author;
import com.yannitech.bookstore.yannitech.model.Book;
import com.yannitech.bookstore.yannitech.repository.AuthorRepository;
import com.yannitech.bookstore.yannitech.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceBean implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceBean(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public void editBook(Book book, Long id) {
        bookRepository.editBook(book.getCategory(), book.getPrice(), book.getTitle(), book.getYear(), id);
    }

    @Override
    public void deleteById(Long bookId) {

        List<Author> authorList = authorRepository.findAllByBook_Id(bookId);

        authorList.forEach(author -> {
            authorRepository.delete(author);
            bookRepository.delete(author.getBook());
        });
    }
}
