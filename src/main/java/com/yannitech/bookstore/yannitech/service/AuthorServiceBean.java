package com.yannitech.bookstore.yannitech.service;

import com.yannitech.bookstore.yannitech.model.Author;
import com.yannitech.bookstore.yannitech.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorServiceBean implements AuthorService{

    private final AuthorRepository authorRepository;

    public AuthorServiceBean(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
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
    public void removeAuthor(Author author) {
        authorRepository.delete(author);
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {
        authorRepository.updateAuthor(author.getAuthor(), author.getId());
    }
}
